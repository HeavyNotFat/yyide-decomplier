/* 智慧班牌 · 云端控制器 */
(function () {
  'use strict';

  var state = {
    data: null,
    catalog: null,
    view: 'dashboard',
    pageIndex: 0,
    selected: null,
    dirty: false,
    library: { q: '', category: '全部', size: '全部' },
    contentTab: 'site',
    endpoint: { q: '', group: '全部', selected: null },
    logs: [],
    logsSince: 0,
    logTimer: null,
    activityQ: '',
    showcaseCats: {}
  };

  var VIEW_META = {
    dashboard: { title: '概览', subtitle: '云端控制器与班牌实时数据' },
    layout: { title: '卡片布局', subtitle: '拖拽卡片、调整尺寸，实时下发到班牌首页' },
    library: { title: '组件库', subtitle: 'APK 内全部 293 个首页组件，任意组合成卡片' },
    content: { title: '内容中心', subtitle: '编辑公告、相册、荣誉、课表等模块数据' },
    endpoints: { title: '接口模拟', subtitle: '257 个接口的响应覆盖与实时请求日志' },
    device: { title: '设备连接', subtitle: '把班牌指向这台控制器并安装调试包' },
    features: { title: '功能地图', subtitle: '全部 Activity、组件分类与启动方式' }
  };

  var GROUPS = ['全部', 'auth', 'device', 'school', 'home', 'messages', 'timetable', 'attendance', 'card', 'userspace', 'activity', 'honor', 'exam', 'library', 'reservation', 'patrol', 'vote', 'dormitory', 'ai', 'upload', 'iot', 'ttlock', 'face', 'external'];

  // ---------------------------------------------------------------------
  // utils
  // ---------------------------------------------------------------------
  function $(sel, root) { return (root || document).querySelector(sel); }
  function $$(sel, root) { return Array.prototype.slice.call((root || document).querySelectorAll(sel)); }
  function esc(value) {
    return String(value == null ? '' : value)
      .replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;')
      .replace(/"/g, '&quot;').replace(/'/g, '&#39;');
  }
  function clone(obj) { return JSON.parse(JSON.stringify(obj)); }
  function clamp(v, lo, hi) { return Math.max(lo, Math.min(hi, v)); }
  function pct(n, total) { return (n / total * 100).toFixed(4) + '%'; }
  function pillActive(a, b) { return a === b ? ' active' : ''; }
  function jsonPretty(v) { return JSON.stringify(v, null, 2); }

  function toast(message, type) {
    var wrap = $('#toasts');
    var el = document.createElement('div');
    el.className = 'toast ' + (type || 'ok');
    el.textContent = message;
    wrap.appendChild(el);
    setTimeout(function () {
      el.style.opacity = '0';
      el.style.transform = 'translateY(6px)';
      setTimeout(function () { el.remove(); }, 220);
    }, 2600);
  }

  function api(path, options) {
    return fetch(path, options).then(function (res) {
      return res.json().then(function (body) {
        if (!res.ok) throw new Error(body && body.error ? body.error : ('HTTP ' + res.status));
        return body;
      });
    });
  }

  function copyText(text) {
    if (navigator.clipboard && navigator.clipboard.writeText) {
      navigator.clipboard.writeText(text).then(function () { toast('已复制'); },
        function () { fallbackCopy(text); });
    } else {
      fallbackCopy(text);
    }
  }
  function fallbackCopy(text) {
    var ta = document.createElement('textarea');
    ta.value = text;
    document.body.appendChild(ta);
    ta.select();
    try { document.execCommand('copy'); toast('已复制'); } catch (e) { toast('复制失败', 'err'); }
    ta.remove();
  }

  function markDirty() {
    state.dirty = true;
    var badge = $('#dirtyBadge');
    if (badge) badge.hidden = false;
  }
  function clearDirty() {
    state.dirty = false;
    var badge = $('#dirtyBadge');
    if (badge) badge.hidden = true;
  }

  // ---------------------------------------------------------------------
  // data access
  // ---------------------------------------------------------------------
  function pages() { return state.data && state.data.layout ? state.data.layout.pages : []; }
  function currentPage() {
    var list = pages();
    if (!list.length) return null;
    state.pageIndex = clamp(state.pageIndex, 0, list.length - 1);
    return list[state.pageIndex];
  }
  function component(tag) {
    var list = state.catalog ? state.catalog.components : [];
    for (var i = 0; i < list.length; i++) if (list[i].tag === tag) return list[i];
    return null;
  }
  function getCard(id) {
    var page = currentPage();
    if (!page) return null;
    for (var i = 0; i < page.cards.length; i++) if (page.cards[i].id === id) return page.cards[i];
    return null;
  }

  function loadState() {
    return api('/api/state').then(function (data) {
      state.data = data;
      state.catalog = data.catalog || { components: [], activities: [], endpoints: [] };
      $('#serverState').textContent = '控制器在线';
      $('#serverDot').classList.remove('off');
      $('#serverAddr').textContent = data.server.host;
      var nc = $('#navComponents');
      var ne = $('#navEndpoints');
      if (nc) nc.textContent = state.catalog.components.length;
      if (ne) ne.textContent = state.catalog.endpoints.length;
      clearDirty();
      render();
      return data;
    }).catch(function (err) {
      $('#serverState').textContent = '控制器离线';
      $('#serverDot').classList.add('off');
      toast('无法连接控制器：' + err.message, 'err');
    });
  }

  function saveLayout() {
    var payload = { pages: pages(), activePage: currentPage() ? currentPage().id : '' };
    api('/api/layout', {
      method: 'PUT', headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(payload)
    }).then(function () {
      state.data.layout = payload;
      clearDirty();
      toast('布局已保存，班牌刷新后生效');
    }).catch(function (err) { toast('保存失败：' + err.message, 'err'); });
  }

  function saveContent() {
    api('/api/content', {
      method: 'PUT', headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(state.data.content)
    }).then(function () { toast('内容已保存'); })
      .catch(function (err) { toast('保存失败：' + err.message, 'err'); });
  }

  function saveSite() {
    api('/api/site', {
      method: 'PUT', headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(state.data.site)
    }).then(function () { toast('站点信息已保存'); })
      .catch(function (err) { toast('保存失败：' + err.message, 'err'); });
  }

  // ---------------------------------------------------------------------
  // shell
  // ---------------------------------------------------------------------
  function setView(view) {
    if (state.dirty && !window.confirm('布局有未保存的修改，仍要离开吗？')) return;
    state.view = view;
    state.selected = null;
    $$('.nav-item').forEach(function (b) { b.classList.toggle('active', b.dataset.view === view); });
    render();
  }

  function renderTopbar() {
    var meta = VIEW_META[state.view];
    $('#pageTitle').textContent = meta.title;
    $('#pageSubtitle').textContent = meta.subtitle;
    var actions = '';
    var dirty = '<span id="dirtyBadge" class="pill" style="border-color:#f4c86a;background:#fff8e6;color:#9a6b00" ' + (state.dirty ? '' : 'hidden') + '>未保存</span>';
    if (state.view === 'layout') {
      actions = dirty +
        '<button class="btn" id="btnPreviewHelp">使用说明</button>' +
        '<button class="btn" id="btnAddCard">＋ 添加卡片</button>' +
        '<button class="btn primary" id="btnSaveLayout">保存布局</button>';
    } else if (state.view === 'content') {
      actions = '<button class="btn" id="btnResetContent">重新载入</button>' +
        '<button class="btn primary" id="btnSaveContent">保存内容</button>';
    } else if (state.view === 'endpoints') {
      actions = '<button class="btn" id="btnClearLogs">清空日志</button>' +
        '<button class="btn" id="btnReload">刷新</button>';
    } else if (state.view === 'device') {
      actions = '<button class="btn" id="btnReload">刷新</button>' +
        '<button class="btn danger" id="btnResetAll">恢复演示数据</button>';
    } else if (state.view === 'library') {
      actions = '<button class="btn primary" id="btnShowcase">生成组件巡展</button>';
    } else {
      actions = '<button class="btn" id="btnReload">刷新</button>';
    }
    $('#topbarActions').innerHTML = actions;
    var save = $('#btnSaveLayout'); if (save) save.onclick = saveLayout;
    var add = $('#btnAddCard'); if (add) add.onclick = function () { openComponentPicker(); };
    var sc = $('#btnShowcase'); if (sc) sc.onclick = openShowcase;
    var help = $('#btnPreviewHelp'); if (help) help.onclick = layoutHelp;
    var sc2 = $('#btnSaveContent'); if (sc2) sc2.onclick = saveContent;
    var rc = $('#btnResetContent'); if (rc) rc.onclick = function () { loadState(); toast('已重新载入'); };
    var cl = $('#btnClearLogs'); if (cl) cl.onclick = clearLogs;
    var rl = $('#btnReload'); if (rl) rl.onclick = function () { loadState(); toast('已刷新'); };
    var ra = $('#btnResetAll'); if (ra) ra.onclick = resetAll;
  }

  function render() {
    if (!state.data) return;
    renderTopbar();
    var view = $('#view');
    if (state.view === 'dashboard') view.innerHTML = viewDashboard();
    else if (state.view === 'layout') view.innerHTML = viewLayout();
    else if (state.view === 'library') view.innerHTML = viewLibrary();
    else if (state.view === 'content') view.innerHTML = viewContent();
    else if (state.view === 'endpoints') view.innerHTML = viewEndpoints();
    else if (state.view === 'device') view.innerHTML = viewDevice();
    else if (state.view === 'features') view.innerHTML = viewFeatures();
    bindView();
    manageLogPolling();
  }

  // ---------------------------------------------------------------------
  // dashboard
  // ---------------------------------------------------------------------
  function viewDashboard() {
    var comps = state.catalog.components;
    var acts = state.catalog.activities;
    var eps = state.catalog.endpoints;
    var pageList = pages();
    var cardCount = 0;
    pageList.forEach(function (p) { cardCount += p.cards.length; });
    var cat = {};
    comps.forEach(function (c) { cat[c.category] = (cat[c.category] || 0) + 1; });
    var topCats = Object.keys(cat).sort(function (a, b) { return cat[b] - cat[a]; }).slice(0, 6);

    var html = '<div class="hero">';
    html += '<h2>班牌的一切，都在这里控制</h2>';
    html += '<p>首页卡片、模块内容、接口响应和功能入口，全部由这台云端控制器接管。</p>';
    html += '<div class="hero-meta">';
    html += '<div><strong>' + comps.length + '</strong><span>可布卡片组件</span></div>';
    html += '<div><strong>' + eps.length + '</strong><span>可模拟接口</span></div>';
    html += '<div><strong>' + acts.length + '</strong><span>Activity 功能入口</span></div>';
    html += '<div><strong>' + pageList.length + '</strong><span>首页分页</span></div>';
    html += '</div></div>';

    html += '<div class="stat-grid">';
    html += statCard('▦', '当前首页卡片', String(cardCount), pageList.length + ' 个分页 · 8×6 栅格');
    html += statCard('◈', '组件分类', String(Object.keys(cat).length), topCats.slice(0, 3).map(function (k) { return k + ' ' + cat[k]; }).join(' · '));
    html += statCard('⇄', '今日请求', String(state.logs.length), '最近日志实时同步');
    html += statCard('⌁', '设备身份', state.data.site.device.mac || '未设置', state.data.site.brand.brandName || '');
    html += '</div>';

    html += '<div class="grid-2 stack">';
    html += '<div class="panel"><div class="panel-head"><div><h3>首页布局</h3><p>当前下发给班牌的分页与卡片</p></div>' +
      '<button class="btn small" data-go="layout">编辑布局</button></div><div class="panel-body">';
    if (!pageList.length) {
      html += '<div class="empty"><div class="big">▦</div>还没有布局，去卡片布局里添加第一张卡片</div>';
    } else {
      pageList.forEach(function (p, i) {
        var names = p.cards.slice(0, 5).map(function (c) { return c.moduleName || c.tag; }).join(' · ');
        html += '<div class="list-row" style="cursor:pointer" data-page="' + i + '">' +
          '<div class="thumb" style="display:grid;place-items:center;color:#2f6bff;font-weight:700">' + (i + 1) + '</div>' +
          '<div class="info"><strong>' + esc(p.name || p.pagination) + '</strong><span>' + p.cards.length + ' 张卡片 · ' + esc(names || '空') + '</span></div>' +
          '<span class="tag-chip">' + esc(p.pagination) + '</span></div>';
      });
    }
    html += '</div></div>';

    html += '<div class="panel"><div class="panel-head"><div><h3>快捷操作</h3><p>常用的控制入口</p></div></div><div class="panel-body"><div class="stack">';
    html += quick('▦', '设计首页', '拖拽、缩放卡片，调整模块名与颜色', 'layout');
    html += quick('✦', '组件巡展', '一键生成覆盖全部组件的多页布局', 'showcase');
    html += quick('✎', '更新内容', '公告、相册、荣誉、课表一次改完', 'content');
    html += quick('⌁', '连接班牌', '查看地址并安装云端调试包', 'device');
    html += '</div></div></div>';
    html += '</div>';

    html += '<div class="panel" style="margin-top:18px"><div class="panel-head"><div><h3>最近请求</h3><p>班牌发给云端控制器的最后几条请求</p></div>' +
      '<button class="btn small" data-go="endpoints">全部日志</button></div><div class="panel-body" style="padding:0">' +
      logsTable(12) + '</div></div>';

    html += '<div class="grid-3" style="margin-top:18px">';
    html += catPanel('分类分布', topCats.map(function (k) { return { name: k, value: cat[k] }; }), comps.length);
    html += catPanel('卡片尺寸', sizeStats(comps), comps.length);
    html += '<div class="panel"><div class="panel-head"><div><h3>快速开始</h3><p>三步把班牌接到本地</p></div></div><div class="panel-body"><div class="steps">' +
      '<div class="step"><div><h4>启动控制器</h4><p>保持 <code class="mono">python cloud-server/server.py</code> 运行。</p></div></div>' +
      '<div class="step"><div><h4>安装云端调试包</h4><p>构建并安装指向本机的 APK，或使用已打包版本。</p></div></div>' +
      '<div class="step"><div><h4>登录并刷新</h4><p>用演示账号登录，首页立即读取这里的布局。</p></div></div>' +
      '</div></div></div>';
    html += '</div>';
    return html;
  }

  function statCard(glyph, label, value, sub) {
    return '<div class="stat"><div class="label"><span class="glyph">' + glyph + '</span>' + esc(label) + '</div>' +
      '<div class="value">' + esc(value) + '</div><div class="sub">' + esc(sub) + '</div></div>';
  }
  function quick(glyph, title, desc, action) {
    return '<div class="quick" data-quick="' + action + '"><div class="glyph">' + glyph + '</div>' +
      '<div><strong>' + esc(title) + '</strong><span>' + esc(desc) + '</span></div></div>';
  }
  function catPanel(title, items, total) {
    var html = '<div class="panel"><div class="panel-head"><div><h3>' + esc(title) + '</h3><p>共 ' + total + ' 个组件</p></div></div><div class="panel-body">';
    items.forEach(function (it) {
      var p = total ? Math.round(it.value / total * 100) : 0;
      html += '<div style="margin-bottom:11px"><div class="row" style="justify-content:space-between;font-size:11px;margin-bottom:5px">' +
        '<span>' + esc(it.name) + '</span><span style="color:#94a3b8">' + it.value + '</span></div>' +
        '<div style="height:6px;border-radius:4px;background:#eef3fb;overflow:hidden"><div style="height:100%;width:' + p + '%;border-radius:4px;background:linear-gradient(90deg,#2f6bff,#6b9cff)"></div></div></div>';
    });
    return html + '</div></div>';
  }
  function sizeStats(comps) {
    var sizes = {};
    comps.forEach(function (c) { sizes[c.size] = (sizes[c.size] || 0) + 1; });
    return Object.keys(sizes).sort(function (a, b) { return sizes[b] - sizes[a]; }).slice(0, 6)
      .map(function (k) { return { name: k, value: sizes[k] }; });
  }

  // ---------------------------------------------------------------------
  // layout designer
  // ---------------------------------------------------------------------
  function viewLayout() {
    var page = currentPage();
    var html = '<div class="layout-shell"><div class="panel">';
    html += '<div class="board-wrap"><div class="board-bar">';
    html += '<div class="page-tabs">';
    pages().forEach(function (p, i) {
      html += '<button class="page-tab' + pillActive(i, state.pageIndex) + '" data-pagetab="' + i + '">' +
        esc(p.name || p.pagination) + '<span class="x" data-delpage="' + i + '">✕</span></button>';
    });
    html += '<button class="page-tab" id="btnAddPage">＋ 分页</button></div>';
    html += '<div class="spacer"></div>';
    html += '<button class="btn small" id="btnRenamePage">重命名</button>';
    html += '<button class="btn small" id="btnDupPage">复制分页</button>';
    html += '<button class="btn small" id="btnClearPage">清空</button>';
    html += '<button class="btn small" id="btnResetLayout">恢复默认</button>';
    html += '</div>';

    if (!page) {
      html += '<div class="empty"><div class="big">▦</div>还没有分页<br><button class="btn primary" id="btnAddPage2" style="margin-top:14px">创建第一页</button></div>';
    } else {
      html += '<div class="board" id="board">';
      page.cards.forEach(function (c) {
        var comp = component(c.tag) || { name: c.moduleName, category: '', fragment: '' };
        var selected = c.id === state.selected ? ' selected' : '';
        var disabled = c.enabled === false ? ' disabled' : '';
        var style = 'left:calc(' + pct(c.x, 8) + ' + 2px);top:calc(' + pct(c.y, 6) + ' + 2px);' +
          'width:calc(' + pct(c.width, 8) + ' - 4px);height:calc(' + pct(c.height, 6) + ' - 4px)';
        html += '<div class="card-tile' + selected + disabled + '" data-card="' + esc(c.id) + '" style="' + style + '">' +
          '<span class="tag">' + esc(c.tag) + '</span>' +
          '<div class="name">' + esc(c.moduleName || comp.name || '未命名') + '</div>' +
          '<div class="body-hint">' + esc(comp.category || '') + '</div>' +
          '<span class="size">' + c.width + '×' + c.height + '</span>' +
          '<span class="resize" data-resize="' + esc(c.id) + '"></span></div>';
      });
      html += '</div>';
      html += '<div class="board-hint"><span>拖动卡片移动</span><span>右下角拖拽缩放</span><span>点击卡片编辑属性</span><span>8 列 × 6 行栅格</span></div>';
    }
    html += '</div></div>';
    html += '<div class="inspector">' + inspectorHtml() + '</div></div>';
    return html;
  }

  function inspectorHtml() {
    var card = state.selected ? getCard(state.selected) : null;
    var html = '<div class="panel"><div class="panel-head"><div><h3>' + (card ? '卡片属性' : '未选择卡片') + '</h3>' +
      '<p>' + (card ? '修改后自动标记为未保存' : '点击左侧卡片进行编辑') + '</p></div>';
    if (card) html += '<button class="icon-btn" id="btnCloseInspector">✕</button>';
    html += '</div><div class="panel-body">';
    if (!card) {
      html += '<div class="empty"><div class="big">✎</div>选择一张卡片<br>即可调整组件、位置与内容</div>';
      return html + '</div></div>';
    }
    var comp = component(card.tag);
    html += '<div class="field"><label>组件标识 <em>' + esc(comp ? comp.fragment : '') + '</em></label>' +
      '<div class="row"><input class="input mono" id="fTag" value="' + esc(card.tag) + '" readonly>' +
      '<button class="btn small" id="btnPickComponent">更换</button></div></div>';
    html += '<div class="field"><label>模块名称</label><input class="input" id="fName" value="' + esc(card.moduleName || '') + '"></div>';
    html += '<div class="field-row">';
    html += '<div class="field"><label>列 x</label><input class="input" type="number" min="0" max="7" id="fX" value="' + card.x + '"></div>';
    html += '<div class="field"><label>行 y</label><input class="input" type="number" min="0" max="5" id="fY" value="' + card.y + '"></div>';
    html += '<div class="field"><label>宽 w</label><input class="input" type="number" min="1" max="8" id="fW" value="' + card.width + '"></div>';
    html += '<div class="field"><label>高 h</label><input class="input" type="number" min="1" max="6" id="fH" value="' + card.height + '"></div>';
    html += '</div>';
    html += '<div class="field-row">';
    html += '<div class="field"><label>边框颜色</label><input class="input" id="fBorder" value="' + esc(card.borderColor || '') + '" placeholder="#2F6BFF"></div>';
    html += '<div class="field"><label>背景颜色</label><input class="input" id="fBack" value="' + esc(card.backgroundColor || '') + '" placeholder="留空为默认"></div>';
    html += '</div>';
    html += '<div class="field"><label>跳转链接 <em>自定义/网页组件</em></label><input class="input" id="fUrl" value="' + esc(card.url || '') + '" placeholder="https://"></div>';
    html += '<div class="field"><label>图片列表 <em>逗号分隔</em></label><textarea class="textarea" id="fImages" style="min-height:54px">' + esc(card.images || '') + '</textarea></div>';
    html += '<div class="field"><label>副标题 / 描述</label><input class="input" id="fDesc" value="' + esc(card.descriptive || '') + '"></div>';
    html += '<div class="field"><label>二次页返回秒数</label><input class="input" type="number" id="fSec" value="' + (card.secPageBackTime || 10) + '"></div>';
    html += '<div class="field"><label class="check"><input type="checkbox" id="fShowName" ' + (card.showModuleName !== false ? 'checked' : '') + '> 显示模块名称</label></div>';
    html += '<div class="field"><label class="check"><input type="checkbox" id="fEnabled" ' + (card.enabled !== false ? 'checked' : '') + '> 在首页启用</label></div>';
    html += '<div class="field"><label>JSON 参数 <em>自定义组件内容</em></label><textarea class="textarea" id="fJson" placeholder="{...}">' + esc(card.jsonParam || '') + '</textarea></div>';
    html += '<div class="meta-line">标签 ' + esc(card.tag) + ' · 组件尺寸 ' + (comp ? comp.size : card.width + '×' + card.height) + ' · ' + esc(comp ? comp.category : '') + '</div>';
    html += '<div class="row" style="margin-top:14px"><button class="btn small" id="btnDupCard">复制</button>' +
      '<button class="btn small danger" id="btnDelCard">删除</button><div class="spacer"></div>' +
      '<button class="btn small" id="btnFitBoard">自动布局</button></div>';
    html += '</div></div>';
    return html;
  }

  function bindBoard() {
    var page = currentPage();
    if (!page) return;
    var board = $('#board');
    var tiles = $$('.card-tile', board);
    tiles.forEach(function (tile) {
      tile.addEventListener('pointerdown', function (ev) {
        var id = tile.dataset.card;
        if (ev.target.classList.contains('resize')) { startResize(ev, id, tile, board); return; }
        selectCard(id);
        startDrag(ev, id, tile, board);
      });
    });
  }

  function startDrag(ev, id, tile, board) {
    var card = getCard(id);
    if (!card) return;
    var rect = board.getBoundingClientRect();
    var cw = rect.width / 8, ch = rect.height / 6;
    var sx = ev.clientX, sy = ev.clientY, ox = card.x, oy = card.y;
    var moved = false;
    tile.setPointerCapture(ev.pointerId);
    function move(e) {
      var dx = Math.round((e.clientX - sx) / cw);
      var dy = Math.round((e.clientY - sy) / ch);
      if (dx || dy) moved = true;
      card.x = clamp(ox + dx, 0, 8 - card.width);
      card.y = clamp(oy + dy, 0, 6 - card.height);
      tile.style.left = 'calc(' + pct(card.x, 8) + ' + 2px)';
      tile.style.top = 'calc(' + pct(card.y, 6) + ' + 2px)';
      syncInspectorPosition(card);
    }
    function up() {
      tile.removeEventListener('pointermove', move);
      tile.removeEventListener('pointerup', up);
      tile.removeEventListener('pointercancel', up);
      if (moved) { markDirty(); renderInspector(); }
    }
    tile.addEventListener('pointermove', move);
    tile.addEventListener('pointerup', up);
    tile.addEventListener('pointercancel', up);
    ev.preventDefault();
  }

  function startResize(ev, id, tile, board) {
    var card = getCard(id);
    if (!card) return;
    var rect = board.getBoundingClientRect();
    var cw = rect.width / 8, ch = rect.height / 6;
    var sx = ev.clientX, sy = ev.clientY, ow = card.width, oh = card.height;
    var moved = false;
    var handle = ev.target;
    handle.setPointerCapture(ev.pointerId);
    function move(e) {
      var dw = Math.round((e.clientX - sx) / cw);
      var dh = Math.round((e.clientY - sy) / ch);
      if (dw || dh) moved = true;
      card.width = clamp(ow + dw, 1, 8 - card.x);
      card.height = clamp(oh + dh, 1, 6 - card.y);
      tile.style.width = 'calc(' + pct(card.width, 8) + ' - 4px)';
      tile.style.height = 'calc(' + pct(card.height, 6) + ' - 4px)';
      syncInspectorSize(card);
    }
    function up() {
      handle.removeEventListener('pointermove', move);
      handle.removeEventListener('pointerup', up);
      handle.removeEventListener('pointercancel', up);
      if (moved) { markDirty(); renderBoardOnly(); }
    }
    handle.addEventListener('pointermove', move);
    handle.addEventListener('pointerup', up);
    handle.addEventListener('pointercancel', up);
    ev.preventDefault();
    ev.stopPropagation();
  }

  function selectCard(id) {
    state.selected = id;
    $$('.card-tile').forEach(function (t) { t.classList.toggle('selected', t.dataset.card === id); });
    renderInspector();
  }

  function renderInspector() {
    var holder = $('.inspector');
    if (!holder) return;
    holder.innerHTML = inspectorHtml();
    bindInspector();
  }

  function renderBoardOnly() {
    var page = currentPage();
    if (!page) return;
    var board = $('#board');
    if (!board) return;
    board.innerHTML = '';
    page.cards.forEach(function (c) {
      var comp = component(c.tag) || { name: c.moduleName, category: '', fragment: '' };
      var div = document.createElement('div');
      div.className = 'card-tile' + (c.id === state.selected ? ' selected' : '') + (c.enabled === false ? ' disabled' : '');
      div.dataset.card = c.id;
      div.style.left = 'calc(' + pct(c.x, 8) + ' + 2px)';
      div.style.top = 'calc(' + pct(c.y, 6) + ' + 2px)';
      div.style.width = 'calc(' + pct(c.width, 8) + ' - 4px)';
      div.style.height = 'calc(' + pct(c.height, 6) + ' - 4px)';
      div.innerHTML = '<span class="tag">' + esc(c.tag) + '</span>' +
        '<div class="name">' + esc(c.moduleName || comp.name || '未命名') + '</div>' +
        '<div class="body-hint">' + esc(comp.category || '') + '</div>' +
        '<span class="size">' + c.width + '×' + c.height + '</span>' +
        '<span class="resize" data-resize="' + esc(c.id) + '"></span>';
      board.appendChild(div);
    });
    bindBoard();
  }

  function syncInspectorPosition(card) {
    var x = $('#fX'), y = $('#fY');
    if (x) x.value = card.x;
    if (y) y.value = card.y;
  }
  function syncInspectorSize(card) {
    var w = $('#fW'), h = $('#fH');
    if (w) w.value = card.width;
    if (h) h.value = card.height;
  }

  function bindInspector() {
    var card = state.selected ? getCard(state.selected) : null;
    if (!card) return;
    var comp = component(card.tag);
    function upd(fn) { fn(); markDirty(); }
    var f;
    f = $('#fName'); if (f) f.oninput = function () { card.moduleName = f.value; var tile = $('[data-card="' + card.id + '"] .name'); if (tile) tile.textContent = f.value; markDirty(); };
    f = $('#fX'); if (f) f.onchange = function () { upd(function () { card.x = clamp(parseInt(f.value, 10) || 0, 0, 8 - card.width); }); renderBoardOnly(); };
    f = $('#fY'); if (f) f.onchange = function () { upd(function () { card.y = clamp(parseInt(f.value, 10) || 0, 0, 6 - card.height); }); renderBoardOnly(); };
    f = $('#fW'); if (f) f.onchange = function () { upd(function () { card.width = clamp(parseInt(f.value, 10) || 1, 1, 8 - card.x); }); renderBoardOnly(); };
    f = $('#fH'); if (f) f.onchange = function () { upd(function () { card.height = clamp(parseInt(f.value, 10) || 1, 1, 6 - card.y); }); renderBoardOnly(); };
    f = $('#fBorder'); if (f) f.oninput = function () { card.borderColor = f.value; markDirty(); };
    f = $('#fBack'); if (f) f.oninput = function () { card.backgroundColor = f.value; markDirty(); };
    f = $('#fUrl'); if (f) f.oninput = function () { card.url = f.value; markDirty(); };
    f = $('#fImages'); if (f) f.oninput = function () { card.images = f.value; markDirty(); };
    f = $('#fDesc'); if (f) f.oninput = function () { card.descriptive = f.value; markDirty(); };
    f = $('#fSec'); if (f) f.onchange = function () { card.secPageBackTime = parseInt(f.value, 10) || 10; markDirty(); };
    f = $('#fJson'); if (f) f.oninput = function () { card.jsonParam = f.value; markDirty(); };
    f = $('#fShowName'); if (f) f.onchange = function () { card.showModuleName = f.checked; markDirty(); };
    f = $('#fEnabled'); if (f) f.onchange = function () { card.enabled = f.checked; markDirty(); renderBoardOnly(); };
    var close = $('#btnCloseInspector'); if (close) close.onclick = function () { state.selected = null; render(); };
    var pick = $('#btnPickComponent'); if (pick) pick.onclick = function () { openComponentPicker(card); };
    var dup = $('#btnDupCard'); if (dup) dup.onclick = function () { duplicateCard(card); };
    var del = $('#btnDelCard'); if (del) del.onclick = function () { deleteCard(card); };
    var fit = $('#btnFitBoard'); if (fit) fit.onclick = function () { fitCard(card); };
  }

  function syncLayoutBoardBar() {
    var page = currentPage();
    if (!page) return;
    $$('[data-pagetab]').forEach(function (b) { b.classList.toggle('active', parseInt(b.dataset.pagetab, 10) === state.pageIndex); });
  }

  function addPage() {
    var name = window.prompt('新分页名称', '分页 ' + (pages().length + 1));
    if (name === null) return;
    var num = pages().length + 1;
    var id = 'page-' + Date.now();
    pages().push({ id: id, name: name || ('分页 ' + num), pagination: id, cards: [] });
    state.pageIndex = pages().length - 1;
    state.selected = null;
    markDirty();
    render();
  }

  function deletePage(index) {
    if (pages().length <= 1) { toast('至少保留一个分页', 'err'); return; }
    if (!window.confirm('删除分页「' + (pages()[index].name || pages()[index].pagination) + '」？')) return;
    pages().splice(index, 1);
    state.pageIndex = clamp(state.pageIndex, 0, pages().length - 1);
    state.selected = null;
    markDirty();
    render();
  }

  function renamePage() {
    var page = currentPage();
    if (!page) return;
    var name = window.prompt('分页名称', page.name || page.pagination);
    if (name === null) return;
    page.name = name;
    var pag = window.prompt('分页标识 pagination（班牌按它匹配布局）', page.pagination);
    if (pag !== null && pag.trim()) page.pagination = pag.trim();
    markDirty();
    render();
  }

  function duplicatePage() {
    var page = currentPage();
    if (!page) return;
    var copy = clone(page);
    copy.id = 'page-' + Date.now();
    copy.pagination = copy.id;
    copy.name = (page.name || page.pagination) + ' 副本';
    copy.cards.forEach(function (c, i) { c.id = 'card-' + Date.now() + '-' + i; });
    pages().push(copy);
    state.pageIndex = pages().length - 1;
    markDirty();
    render();
  }

  function clearPage() {
    var page = currentPage();
    if (!page || !page.cards.length) return;
    if (!window.confirm('清空当前分页的全部卡片？')) return;
    page.cards = [];
    state.selected = null;
    markDirty();
    render();
  }

  function occupyGrid(page) {
    var grid = [];
    for (var y = 0; y < 6; y++) { grid.push([false, false, false, false, false, false, false, false]); }
    page.cards.forEach(function (c) {
      for (var yy = c.y; yy < c.y + c.height; yy++) {
        for (var xx = c.x; xx < c.x + c.width; xx++) {
          if (grid[yy] && grid[yy][xx] !== undefined) grid[yy][xx] = true;
        }
      }
    });
    return grid;
  }

  function findSlot(page, w, h) {
    var grid = occupyGrid(page);
    for (var y = 0; y <= 6 - h; y++) {
      for (var x = 0; x <= 8 - w; x++) {
        var ok = true;
        for (var yy = y; yy < y + h && ok; yy++) {
          for (var xx = x; xx < x + w; xx++) { if (grid[yy][xx]) { ok = false; break; } }
        }
        if (ok) return { x: x, y: y };
      }
    }
    return null;
  }

  function addCard(tag, comp) {
    var page = currentPage();
    if (!page) return;
    comp = comp || component(tag) || { width: 2, height: 2, name: '新卡片' };
    var w = clamp(comp.width || 2, 1, 8);
    var h = clamp(comp.height || 2, 1, 6);
    var slot = findSlot(page, w, h);
    if (!slot) {
      var pid = 'page-' + Date.now();
      pages().push({ id: pid, name: '分页 ' + (pages().length + 1), pagination: pid, cards: [] });
      state.pageIndex = pages().length - 1;
      page = currentPage();
      slot = findSlot(page, w, h);
      toast('当前页已满，已自动新建分页');
    }
    if (!slot) { toast('没有可用空间', 'err'); return; }
    var card = {
      id: 'card-' + Date.now() + '-' + Math.floor(Math.random() * 1000),
      tag: tag, moduleName: comp.name || '', x: slot.x, y: slot.y, width: w, height: h,
      borderColor: '', backgroundColor: '', showModuleName: true, jsonParam: '',
      url: '', imgType: '', images: '', descriptive: '', secPageBackTime: 10, enabled: true
    };
    page.cards.push(card);
    state.selected = card.id;
    markDirty();
    render();
    toast('已添加「' + (comp.name || tag) + '」');
  }

  function duplicateCard(card) {
    var page = currentPage();
    var slot = findSlot(page, card.width, card.height);
    if (!slot) { toast('没有空位了', 'err'); return; }
    var copy = clone(card);
    copy.id = 'card-' + Date.now();
    copy.x = slot.x; copy.y = slot.y;
    page.cards.push(copy);
    state.selected = copy.id;
    markDirty();
    render();
  }

  function deleteCard(card) {
    var page = currentPage();
    page.cards = page.cards.filter(function (c) { return c.id !== card.id; });
    state.selected = null;
    markDirty();
    render();
  }

  function fitCard(card) {
    card.x = 0; card.y = 0;
    markDirty();
    render();
  }

  function layoutHelp() {
    openModal('布局使用说明',
      '<div class="stack">' +
      '<p style="margin:0;font-size:12.5px;line-height:1.8;color:#475569">首页由 <b>8 列 × 6 行</b> 栅格组成，每个组件的尺寸由组件本身决定（标签后缀即宽高，例如 <code class="mono">hbtzgg25</code> 是 2×5）。</p>' +
      '<div class="code">拖动 = 移动位置\n右下角 = 缩放尺寸（不能超过组件原生尺寸太多）\n8×6 = 一屏；超出可新建分页\n保存后班牌下拉刷新或重启生效</div>' +
      '<p style="margin:0;font-size:12px;color:#64748b">提示：想一次浏览所有功能，去「组件库」点「生成组件巡展」，会把全部组件自动排成多页。</p>' +
      '</div>', '<button class="btn primary" onclick="document.getElementById(\'modalBackdrop\').hidden=true">知道了</button>');
  }

  // ---------------------------------------------------------------------
  // component library
  // ---------------------------------------------------------------------
  function viewLibrary() {
    var comps = state.catalog.components;
    var cats = state.catalog.categories || [];
    var sizes = {};
    comps.forEach(function (c) { sizes[c.size] = (sizes[c.size] || 0) + 1; });
    var sizeList = Object.keys(sizes).sort(function (a, b) { return sizes[b] - sizes[a]; });
    var filtered = comps.filter(function (c) {
      if (state.library.category !== '全部' && c.category !== state.library.category) return false;
      if (state.library.size !== '全部' && c.size !== state.library.size) return false;
      var q = state.library.q.toLowerCase();
      if (q && (c.tag + ' ' + c.name + ' ' + c.fragment + ' ' + c.category).toLowerCase().indexOf(q) < 0) return false;
      return true;
    });
    var html = '<div class="panel"><div class="panel-body">';
    html += '<div class="toolbar"><div class="search"><input class="input" id="libSearch" placeholder="搜索标签、名称、Fragment…" value="' + esc(state.library.q) + '"></div>' +
      '<span class="pill">共 ' + filtered.length + ' 个</span></div>';
    html += '<div class="toolbar" style="gap:6px">';
    var catList = ['全部'].concat(cats);
    catList.forEach(function (c) {
      if (c !== '全部' && !comps.some(function (x) { return x.category === c; })) return;
      html += '<button class="pill' + pillActive(state.library.category, c) + '" data-libcat="' + esc(c) + '">' + esc(c) + '</button>';
    });
    html += '</div>';
    html += '<div class="toolbar" style="gap:6px;margin-bottom:18px">';
    html += '<button class="pill' + pillActive(state.library.size, '全部') + '" data-libsize="全部">全部尺寸</button>';
    sizeList.slice(0, 14).forEach(function (s) {
      html += '<button class="pill' + pillActive(state.library.size, s) + '" data-libsize="' + esc(s) + '">' + esc(s) + '</button>';
    });
    html += '</div>';
    if (!filtered.length) {
      html += '<div class="empty"><div class="big">⌕</div>没有匹配的组件</div>';
    } else {
      html += '<div class="comp-grid">';
      filtered.forEach(function (c) {
        html += '<div class="comp-card">' +
          '<div class="top"><span class="tag">' + esc(c.tag) + '</span><span class="badge">' + esc(c.size) + '</span></div>' +
          '<h4>' + esc(c.name) + '</h4>' +
          '<div class="frag">' + esc(c.fragment || '—') + '</div>' +
          '<div style="font-size:10.5px;color:#94a3b8">' + esc(c.category) + '</div>' +
          '<div class="actions"><button class="btn small primary" data-addtag="' + esc(c.tag) + '">加入布局</button>' +
          '<button class="btn small" data-copytag="' + esc(c.tag) + '">复制标签</button></div></div>';
      });
      html += '</div>';
    }
    html += '</div></div>';
    return html;
  }

  function openComponentPicker(replaceCard) {
    var comps = state.catalog.components;
    var body = '<div class="search" style="margin-bottom:12px"><input class="input" id="pickSearch" placeholder="搜索组件…"></div>' +
      '<div id="pickList" style="display:grid;grid-template-columns:repeat(auto-fill,minmax(210px,1fr));gap:8px;max-height:52vh;overflow:auto">';
    comps.forEach(function (c) {
      body += '<button class="comp-card" style="text-align:left;cursor:pointer" data-picktag="' + esc(c.tag) + '">' +
        '<div class="top"><span class="tag">' + esc(c.tag) + '</span><span class="badge">' + esc(c.size) + '</span></div>' +
        '<h4>' + esc(c.name) + '</h4><div class="frag">' + esc(c.category) + '</div></button>';
    });
    body += '</div>';
    openModal(replaceCard ? '更换组件' : '添加卡片', body, '<button class="btn" id="pickCancel">取消</button>', { wide: true });
    var search = $('#pickSearch');
    if (search) search.oninput = function () {
      var q = search.value.toLowerCase();
      $$('[data-picktag]').forEach(function (b) {
        var c = component(b.dataset.picktag);
        var text = (c.tag + ' ' + c.name + ' ' + c.category).toLowerCase();
        b.style.display = text.indexOf(q) >= 0 ? '' : 'none';
      });
    };
    $('#pickCancel').onclick = closeModal;
    $$('[data-picktag]').forEach(function (b) {
      b.onclick = function () {
        var tag = b.dataset.picktag;
        var comp = component(tag);
        closeModal();
        if (replaceCard) {
          var card = getCard(replaceCard.id);
          card.tag = tag;
          card.moduleName = comp.name;
          card.width = clamp(comp.width || card.width, 1, 8);
          card.height = clamp(comp.height || card.height, 1, 6);
          markDirty();
          render();
        } else {
          addCard(tag, comp);
        }
      };
    });
  }

  // ---------------------------------------------------------------------
  // content center
  // ---------------------------------------------------------------------
  var CONTENT_TABS = [
    { id: 'site', name: '站点与班级', glyph: '⌂' },
    { id: 'notices', name: '通知公告', glyph: '✉' },
    { id: 'albums', name: '相册', glyph: '▣' },
    { id: 'videos', name: '视频', glyph: '▶' },
    { id: 'honors', name: '荣誉', glyph: '★' },
    { id: 'generic', name: '其他模块', glyph: '▤' },
    { id: 'weather', name: '天气/倒计时', glyph: '☀' }
  ];

  function viewContent() {
    var html = '<div class="content-grid"><div class="panel"><div class="panel-body" style="padding:10px"><div class="subnav">';
    CONTENT_TABS.forEach(function (t) {
      html += '<button class="' + (state.contentTab === t.id ? 'active' : '') + '" data-ctab="' + t.id + '">' +
        '<span>' + t.glyph + '</span>' + esc(t.name) + '</button>';
    });
    html += '</div></div></div><div id="contentPane">' + contentPane() + '</div></div>';
    return html;
  }

  function contentPane() {
    if (state.contentTab === 'site') return paneSite();
    if (state.contentTab === 'notices') return paneNotices();
    if (state.contentTab === 'albums') return paneAlbums();
    if (state.contentTab === 'videos') return paneVideos();
    if (state.contentTab === 'honors') return paneHonors();
    if (state.contentTab === 'weather') return paneWeather();
    return paneGeneric();
  }

  function paneSite() {
    var s = state.data.site;
    var b = s.brand, sc = s.school, cl = s.classes, d = s.device;
    var html = '<div class="panel"><div class="panel-head"><div><h3>站点与班级</h3><p>班牌登录后展示的身份信息</p></div></div><div class="panel-body">';
    html += '<div class="grid-2" style="gap:18px"><div>';
    html += inputField('学校名称', 's-schoolName', sc.schoolName);
    html += inputField('英文名', 's-englishName', sc.englishName);
    html += inputField('班级名称', 's-className', cl.classesName);
    html += inputField('年级', 's-grade', cl.gradeName);
    html += inputField('班主任', 's-teacher', cl.headerTeacher);
    html += inputField('班级口号', 's-slogan', cl.slogan);
    html += '</div><div>';
    html += inputField('班牌名称', 's-brandName', b.brandName);
    html += inputField('场地名称', 's-siteName', b.siteName);
    html += inputField('班级人数', 's-count', cl.studentCount, 'number');
    html += inputField('教室', 's-room', cl.classroom);
    html += inputField('设备 MAC', 's-mac', d.mac);
    html += inputField('版本号', 's-version', d.version);
    html += '</div></div>';
    html += '<div class="row" style="margin-top:14px"><div class="spacer"></div><button class="btn primary" id="btnSaveSite">保存站点信息</button></div>';
    html += '</div></div>';
    return html;
  }

  function inputField(label, id, value, type) {
    return '<div class="field"><label>' + esc(label) + '</label><input class="input" id="' + id + '" type="' +
      (type || 'text') + '" value="' + esc(value == null ? '' : value) + '"></div>';
  }

  function paneNotices() {
    var list = state.data.content.notices || [];
    var html = '<div class="panel"><div class="panel-head"><div><h3>通知公告</h3><p>首页通知卡片与校园消息使用这些数据</p></div>' +
      '<button class="btn primary small" id="btnAddNotice">＋ 新增公告</button></div><div class="panel-body">';
    if (!list.length) html += '<div class="empty"><div class="big">✉</div>还没有公告</div>';
    list.forEach(function (n, i) {
      html += '<div class="list-row"><img class="thumb" src="' + esc(n.coverImg || '/mock/cover-1.jpg') + '" alt="">' +
        '<div class="info"><strong>' + esc(n.title) + '</strong><span>' + esc(n.source || '') + ' · ' + esc(n.timerDate || '') + ' · ' + esc(n.author || '') + '</span></div>' +
        '<div class="ops"><button class="btn small" data-editnotice="' + i + '">编辑</button>' +
        '<button class="btn small danger" data-delnotice="' + i + '">删除</button></div></div>';
    });
    html += '</div></div>';
    return html;
  }

  function paneAlbums() {
    var c = state.data.content.albums || { class: [], campus: [] };
    var html = '<div class="panel"><div class="panel-head"><div><h3>相册</h3><p>班级相册与校园相册的图片组</p></div>' +
      '<button class="btn primary small" id="btnAddAlbum">＋ 新增相册</button></div><div class="panel-body">';
    ['class', 'campus'].forEach(function (kind) {
      html += '<h4 style="font-size:12px;color:#64748b;margin:6px 0 10px">' + (kind === 'class' ? '班级相册' : '校园相册') + '</h4>';
      (c[kind] || []).forEach(function (a, i) {
        html += '<div class="list-row"><img class="thumb" src="' + esc(a.cover) + '" alt="">' +
          '<div class="info"><strong>' + esc(a.name) + '</strong><span>' + (a.images || []).length + ' 张 · ' + esc(a.date || '') + '</span></div>' +
          '<div class="ops"><button class="btn small" data-editalbum="' + kind + ':' + i + '">编辑</button>' +
          '<button class="btn small danger" data-delalbum="' + kind + ':' + i + '">删除</button></div></div>';
      });
    });
    html += '</div></div>';
    return html;
  }

  function paneVideos() {
    var list = state.data.content.videos || [];
    var html = '<div class="panel"><div class="panel-head"><div><h3>视频</h3><p>校园视频卡片的播放列表</p></div>' +
      '<button class="btn primary small" id="btnAddVideo">＋ 新增视频</button></div><div class="panel-body">';
    list.forEach(function (v, i) {
      html += '<div class="list-row"><img class="thumb" src="' + esc(v.cover || '/mock/cover-8.jpg') + '" alt="">' +
        '<div class="info"><strong>' + esc(v.name) + '</strong><span class="mono">' + esc(v.url) + '</span></div>' +
        '<div class="ops"><button class="btn small" data-editvideo="' + i + '">编辑</button>' +
        '<button class="btn small danger" data-delvideo="' + i + '">删除</button></div></div>';
    });
    html += '</div></div>';
    return html;
  }

  function paneHonors() {
    var list = state.data.content.honors || [];
    var html = '<div class="panel"><div class="panel-head"><div><h3>荣誉墙</h3><p>首页荣誉卡片与班级荣誉</p></div>' +
      '<button class="btn primary small" id="btnAddHonor">＋ 新增荣誉</button></div><div class="panel-body">';
    list.forEach(function (h, i) {
      html += '<div class="list-row"><img class="thumb" src="' + esc(h.avatar || '/mock/avatar-1.png') + '" alt="">' +
        '<div class="info"><strong>' + esc(h.name) + ' · ' + esc(h.studentName) + '</strong><span>' + esc(h.reason) + ' · ' + esc(h.date) + '</span></div>' +
        '<div class="ops"><button class="btn small" data-edithonor="' + i + '">编辑</button>' +
        '<button class="btn small danger" data-delhonor="' + i + '">删除</button></div></div>';
    });
    html += '</div></div>';
    return html;
  }

  function paneWeather() {
    var w = state.data.site.weather || {};
    var cds = state.data.content.countdowns || [];
    var html = '<div class="panel"><div class="panel-head"><div><h3>天气与倒计时</h3><p>首页天气、倒计时卡片</p></div></div><div class="panel-body">';
    html += '<div class="grid-2" style="gap:18px"><div>';
    html += inputField('城市', 'w-area', w.area);
    html += inputField('天气', 'w-weather', w.weather);
    html += inputField('当前温度', 'w-real', w.real);
    html += inputField('最高温', 'w-high', w.highest);
    html += inputField('最低温', 'w-low', w.lowest);
    html += '</div><div>';
    html += inputField('AQI', 'w-aqi', w.aqi);
    html += inputField('空气质量', 'w-quality', w.quality);
    html += inputField('风向', 'w-wind', w.wind);
    html += inputField('风力', 'w-windsc', w.windsc);
    html += inputField('温馨提示', 'w-tips', w.tips);
    html += '</div></div>';
    html += '<div class="row" style="margin:12px 0 18px"><div class="spacer"></div><button class="btn" id="btnSaveWeather">保存天气</button></div>';
    html += '<h4 style="font-size:12px;color:#64748b;margin:0 0 10px">倒计时（JSON）</h4>';
    html += '<textarea class="textarea" id="countdownJson" style="min-height:150px">' + esc(jsonPretty(cds)) + '</textarea>';
    html += '<div class="row" style="margin-top:10px"><div class="spacer"></div><button class="btn primary" id="btnSaveCountdown">保存倒计时</button></div>';
    html += '</div></div>';
    return html;
  }

  function paneGeneric() {
    var keys = ['duty', 'works', 'exams', 'books', 'activities', 'votes', 'schedule', 'repairs'];
    var html = '<div class="panel"><div class="panel-head"><div><h3>其他模块数据</h3><p>值日、作品、考试、图书、活动、投票、课表、报修</p></div></div><div class="panel-body">';
    html += '<div class="toolbar"><select class="select" id="genericKey" style="max-width:220px">';
    keys.forEach(function (k) {
      html += '<option value="' + k + '"' + (state.genericKey === k ? ' selected' : '') + '>' + k + '</option>';
    });
    html += '</select><span style="font-size:11px;color:#94a3b8">直接编辑 JSON 数组，保存后立即生效</span></div>';
    var key = state.genericKey || 'duty';
    html += '<textarea class="textarea" id="genericJson" style="min-height:380px">' + esc(jsonPretty(state.data.content[key] || [])) + '</textarea>';
    html += '<div class="row" style="margin-top:10px"><div class="spacer"></div><button class="btn primary" id="btnSaveGeneric">保存 ' + key + '</button></div>';
    html += '</div></div>';
    return html;
  }

  function bindContent() {
    $$('[data-ctab]').forEach(function (b) {
      b.onclick = function () { state.contentTab = b.dataset.ctab; render(); };
    });
    var b2 = $('#btnSaveSite'); if (b2) b2.onclick = function () {
      var s = state.data.site;
      s.school.schoolName = $('#s-schoolName').value;
      s.school.englishName = $('#s-englishName').value;
      s.classes.classesName = $('#s-className').value;
      s.classes.gradeName = $('#s-grade').value;
      s.classes.headerTeacher = $('#s-teacher').value;
      s.classes.slogan = $('#s-slogan').value;
      s.brand.brandName = $('#s-brandName').value;
      s.brand.siteName = $('#s-siteName').value;
      s.classes.studentCount = parseInt($('#s-count').value, 10) || 0;
      s.classes.classroom = $('#s-room').value;
      s.device.mac = $('#s-mac').value;
      s.device.version = $('#s-version').value;
      saveSite();
    };
    var addN = $('#btnAddNotice'); if (addN) addN.onclick = function () { editNotice(-1); };
    $$('[data-editnotice]').forEach(function (b) { b.onclick = function () { editNotice(parseInt(b.dataset.editnotice, 10)); }; });
    $$('[data-delnotice]').forEach(function (b) { b.onclick = function () { delItem('notices', parseInt(b.dataset.delnotice, 10)); }; });
    var addA = $('#btnAddAlbum'); if (addA) addA.onclick = function () { editAlbum('class', -1); };
    $$('[data-editalbum]').forEach(function (b) {
      b.onclick = function () { var p = b.dataset.editalbum.split(':'); editAlbum(p[0], parseInt(p[1], 10)); };
    });
    $$('[data-delalbum]').forEach(function (b) {
      b.onclick = function () {
        var p = b.dataset.delalbum.split(':');
        if (!window.confirm('删除这个相册？')) return;
        state.data.content.albums[p[0]].splice(parseInt(p[1], 10), 1);
        saveContent(); render();
      };
    });
    var addV = $('#btnAddVideo'); if (addV) addV.onclick = function () { editVideo(-1); };
    $$('[data-editvideo]').forEach(function (b) { b.onclick = function () { editVideo(parseInt(b.dataset.editvideo, 10)); }; });
    $$('[data-delvideo]').forEach(function (b) { b.onclick = function () { delItem('videos', parseInt(b.dataset.delvideo, 10)); }; });
    var addH = $('#btnAddHonor'); if (addH) addH.onclick = function () { editHonor(-1); };
    $$('[data-edithonor]').forEach(function (b) { b.onclick = function () { editHonor(parseInt(b.dataset.edithonor, 10)); }; });
    $$('[data-delhonor]').forEach(function (b) { b.onclick = function () { delItem('honors', parseInt(b.dataset.delhonor, 10)); }; });
    var sw = $('#btnSaveWeather'); if (sw) sw.onclick = function () {
      var w = state.data.site.weather;
      w.area = $('#w-area').value; w.weather = $('#w-weather').value; w.real = $('#w-real').value;
      w.highest = $('#w-high').value; w.lowest = $('#w-low').value; w.aqi = $('#w-aqi').value;
      w.quality = $('#w-quality').value; w.wind = $('#w-wind').value; w.windsc = $('#w-windsc').value;
      w.tips = $('#w-tips').value;
      saveSite(); render();
    };
    var scd = $('#btnSaveCountdown'); if (scd) scd.onclick = function () {
      try { state.data.content.countdowns = JSON.parse($('#countdownJson').value); saveContent(); render(); }
      catch (e) { toast('JSON 格式错误：' + e.message, 'err'); }
    };
    var gk = $('#genericKey'); if (gk) gk.onchange = function () { state.genericKey = gk.value; render(); };
    var sg = $('#btnSaveGeneric'); if (sg) sg.onclick = function () {
      try {
        state.data.content[state.genericKey || 'duty'] = JSON.parse($('#genericJson').value);
        saveContent(); toast('已保存');
      } catch (e) { toast('JSON 格式错误：' + e.message, 'err'); }
    };
  }

  function delItem(key, index) {
    if (!window.confirm('删除这一条？')) return;
    state.data.content[key].splice(index, 1);
    saveContent(); render();
  }

  function editNotice(index) {
    var list = state.data.content.notices;
    var n = index >= 0 ? clone(list[index]) : { id: 'notice-' + Date.now(), title: '', content: '', source: '班级', author: '张明', timerDate: new Date().toISOString().slice(0, 10), coverImg: '/mock/cover-1.jpg', messType: 1, contentType: 1, type: 1, attachments: [], details: [] };
    var body = '<div class="field"><label>标题</label><input class="input" id="nTitle" value="' + esc(n.title) + '"></div>' +
      '<div class="field-row"><div class="field"><label>来源</label><input class="input" id="nSource" value="' + esc(n.source) + '"></div>' +
      '<div class="field"><label>发布人</label><input class="input" id="nAuthor" value="' + esc(n.author) + '"></div></div>' +
      '<div class="field"><label>日期</label><input class="input" id="nDate" value="' + esc(n.timerDate) + '"></div>' +
      '<div class="field"><label>封面图</label><input class="input" id="nCover" value="' + esc(n.coverImg) + '"></div>' +
      '<div class="field"><label>类型</label><select class="select" id="nMess"><option value="1"' + (n.messType === 1 ? ' selected' : '') + '>普通公告</option><option value="2"' + (n.messType === 2 ? ' selected' : '') + '>图文详情</option></select></div>' +
      '<div class="field"><label>正文 HTML</label><textarea class="textarea" id="nContent" style="min-height:160px">' + esc(n.content) + '</textarea></div>';
    openModal(index >= 0 ? '编辑公告' : '新增公告', body,
      '<button class="btn" id="mCancel">取消</button><button class="btn primary" id="mSave">保存</button>', { wide: true });
    $('#mCancel').onclick = closeModal;
    $('#mSave').onclick = function () {
      n.title = $('#nTitle').value; n.source = $('#nSource').value; n.author = $('#nAuthor').value;
      n.timerDate = $('#nDate').value; n.coverImg = $('#nCover').value; n.contentImg = n.coverImg;
      n.messType = parseInt($('#nMess').value, 10); n.content = $('#nContent').value;
      if (index >= 0) list[index] = n; else list.unshift(n);
      closeModal(); saveContent(); render();
    };
  }

  function editAlbum(kind, index) {
    var list = state.data.content.albums[kind];
    var a = index >= 0 ? clone(list[index]) : { id: 'album-' + Date.now(), name: '', cover: '/mock/album-1.jpg', images: ['/mock/album-1.jpg'], date: new Date().toISOString().slice(0, 10) };
    var body = '<div class="field"><label>相册名</label><input class="input" id="aName" value="' + esc(a.name) + '"></div>' +
      '<div class="field"><label>封面</label><input class="input" id="aCover" value="' + esc(a.cover) + '"></div>' +
      '<div class="field"><label>图片 URL（每行一个）</label><textarea class="textarea" id="aImages" style="min-height:140px">' + esc((a.images || []).join('\n')) + '</textarea></div>' +
      '<div class="field"><label>日期</label><input class="input" id="aDate" value="' + esc(a.date) + '"></div>';
    openModal(index >= 0 ? '编辑相册' : '新增相册', body,
      '<button class="btn" id="mCancel">取消</button><button class="btn primary" id="mSave">保存</button>');
    $('#mCancel').onclick = closeModal;
    $('#mSave').onclick = function () {
      a.name = $('#aName').value; a.cover = $('#aCover').value; a.date = $('#aDate').value;
      a.images = $('#aImages').value.split('\n').map(function (s) { return s.trim(); }).filter(Boolean);
      if (index >= 0) list[index] = a; else list.push(a);
      closeModal(); saveContent(); render();
    };
  }

  function editVideo(index) {
    var list = state.data.content.videos;
    var v = index >= 0 ? clone(list[index]) : { id: 'video-' + Date.now(), name: '', url: '/mock/video-1.mp4', cover: '/mock/cover-8.jpg' };
    var body = '<div class="field"><label>名称</label><input class="input" id="vName" value="' + esc(v.name) + '"></div>' +
      '<div class="field"><label>视频地址</label><input class="input" id="vUrl" value="' + esc(v.url) + '"></div>' +
      '<div class="field"><label>封面</label><input class="input" id="vCover" value="' + esc(v.cover) + '"></div>';
    openModal(index >= 0 ? '编辑视频' : '新增视频', body,
      '<button class="btn" id="mCancel">取消</button><button class="btn primary" id="mSave">保存</button>');
    $('#mCancel').onclick = closeModal;
    $('#mSave').onclick = function () {
      v.name = $('#vName').value; v.url = $('#vUrl').value; v.cover = $('#vCover').value;
      if (index >= 0) list[index] = v; else list.push(v);
      closeModal(); saveContent(); render();
    };
  }

  function editHonor(index) {
    var list = state.data.content.honors;
    var h = index >= 0 ? clone(list[index]) : { id: 'honor-' + Date.now(), name: '', studentName: '', reason: '', date: new Date().toISOString().slice(0, 10), avatar: '/mock/avatar-1.png', level: '班级' };
    var body = '<div class="field-row"><div class="field"><label>荣誉名称</label><input class="input" id="hName" value="' + esc(h.name) + '"></div>' +
      '<div class="field"><label>获得者</label><input class="input" id="hStudent" value="' + esc(h.studentName) + '"></div></div>' +
      '<div class="field"><label>事迹</label><textarea class="textarea" id="hReason">' + esc(h.reason) + '</textarea></div>' +
      '<div class="field-row"><div class="field"><label>日期</label><input class="input" id="hDate" value="' + esc(h.date) + '"></div>' +
      '<div class="field"><label>级别</label><input class="input" id="hLevel" value="' + esc(h.level) + '"></div></div>' +
      '<div class="field"><label>头像</label><input class="input" id="hAvatar" value="' + esc(h.avatar) + '"></div>';
    openModal(index >= 0 ? '编辑荣誉' : '新增荣誉', body,
      '<button class="btn" id="mCancel">取消</button><button class="btn primary" id="mSave">保存</button>');
    $('#mCancel').onclick = closeModal;
    $('#mSave').onclick = function () {
      h.name = $('#hName').value; h.studentName = $('#hStudent').value; h.reason = $('#hReason').value;
      h.date = $('#hDate').value; h.level = $('#hLevel').value; h.avatar = $('#hAvatar').value;
      if (index >= 0) list[index] = h; else list.unshift(h);
      closeModal(); saveContent(); render();
    };
  }

  // ---------------------------------------------------------------------
  // endpoints
  // ---------------------------------------------------------------------
  function viewEndpoints() {
    var eps = state.catalog.endpoints;
    var filtered = eps.filter(function (e) {
      if (state.endpoint.group !== '全部' && e.group !== state.endpoint.group) return false;
      var q = state.endpoint.q.toLowerCase();
      if (q && (e.path + ' ' + e.description + ' ' + e.id).toLowerCase().indexOf(q) < 0) return false;
      return true;
    });
    var selected = state.endpoint.selected ? eps.filter(function (e) { return e.id === state.endpoint.selected; })[0] : null;
    var html = '<div class="endpoint-shell"><div class="panel"><div class="panel-body" style="padding:14px">';
    html += '<div class="toolbar"><div class="search"><input class="input" id="epSearch" placeholder="搜索路径或说明…" value="' + esc(state.endpoint.q) + '"></div></div>';
    html += '<div class="toolbar" style="gap:5px">';
    GROUPS.forEach(function (g) {
      html += '<button class="pill' + pillActive(state.endpoint.group, g) + '" data-epgroup="' + esc(g) + '">' + esc(g) + '</button>';
    });
    html += '</div><div style="max-height:62vh;overflow:auto;border:1px solid #e4eaf4;border-radius:11px">';
    filtered.slice(0, 300).forEach(function (e) {
      html += '<div class="endpoint-item' + (state.endpoint.selected === e.id ? ' active' : '') + '" data-ep="' + esc(e.id) + '">' +
        '<span class="method ' + esc(e.method) + '">' + esc(e.method) + '</span>' +
        '<div style="flex:1;min-width:0"><div class="endpoint-path">' + esc(e.path) + '</div><div class="endpoint-desc">' + esc(e.description) + '</div></div>' +
        '<span class="tag-chip">' + esc(e.id) + '</span></div>';
    });
    if (!filtered.length) html += '<div class="empty">没有匹配接口</div>';
    html += '</div></div></div>';
    html += '<div class="stack">';
    html += '<div class="panel"><div class="panel-head"><div><h3>接口覆盖</h3><p>返回自定义 JSON，优先于内置模拟</p></div></div><div class="panel-body">';
    if (!selected) {
      html += '<div class="empty"><div class="big">⇄</div>从左侧选择一个接口</div>';
    } else {
      var ov = (state.data.overrides.items || {})[selected.path];
      html += '<div class="field"><label>接口</label><div class="row"><span class="method ' + esc(selected.method) + '">' + esc(selected.method) + '</span>' +
        '<span class="mono" style="font-size:11px">' + esc(selected.path) + '</span></div></div>';
      html += '<div class="meta-line">' + esc(selected.description) + '<br>来源 ' + esc(selected.id) + ' · ' + esc(selected.base || '本地模拟') + '</div>';
      html += '<div class="field" style="margin-top:12px"><label class="check"><input type="checkbox" id="ovEnabled" ' + (ov ? (ov.enabled !== false ? 'checked' : '') : 'checked') + '> 启用自定义响应</label></div>';
      var sample = ov ? ov.body : envelopeSample(selected);
      if (typeof sample !== 'string') sample = jsonPretty(sample);
      html += '<div class="field"><label>响应 JSON</label><textarea class="textarea" id="ovBody" style="min-height:210px">' + esc(sample) + '</textarea></div>';
      html += '<div class="row"><button class="btn small" id="ovTemplate">插入模板</button><div class="spacer"></div>' +
        '<button class="btn small danger" id="ovDelete">删除覆盖</button><button class="btn primary small" id="ovSave">保存覆盖</button></div>';
    }
    html += '</div></div>';
    html += '<div class="panel"><div class="panel-head"><div><h3>实时请求</h3><p>每 2 秒自动刷新</p></div></div><div class="panel-body" style="padding:0">' + logsTable(40) + '</div></div>';
    html += '</div></div>';
    return html;
  }

  function envelopeSample(ep) {
    if (ep.method === 'GET') return { code: 0, message: '操作成功', data: {} };
    return { code: 0, message: '操作成功', data: {} };
  }

  function bindEndpoints() {
    var search = $('#epSearch');
    if (search) search.oninput = function () { state.endpoint.q = search.value; render(); };
    $$('[data-epgroup]').forEach(function (b) {
      b.onclick = function () { state.endpoint.group = b.dataset.epgroup; render(); };
    });
    $$('[data-ep]').forEach(function (b) {
      b.onclick = function () { state.endpoint.selected = b.dataset.ep; render(); };
    });
    var save = $('#ovSave');
    if (save) save.onclick = function () {
      var ep = state.catalog.endpoints.filter(function (e) { return e.id === state.endpoint.selected; })[0];
      var body;
      try { body = JSON.parse($('#ovBody').value); } catch (e) { toast('JSON 错误：' + e.message, 'err'); return; }
      var enabled = $('#ovEnabled').checked;
      var items = state.data.overrides.items || {};
      items[ep.path] = { enabled: enabled, body: body };
      state.data.overrides.items = items;
      api('/api/overrides', {
        method: 'PUT', headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(state.data.overrides)
      }).then(function () { toast('接口覆盖已保存'); render(); })
        .catch(function (err) { toast('保存失败：' + err.message, 'err'); });
    };
    var del = $('#ovDelete');
    if (del) del.onclick = function () {
      var ep = state.catalog.endpoints.filter(function (e) { return e.id === state.endpoint.selected; })[0];
      delete state.data.overrides.items[ep.path];
      api('/api/overrides', {
        method: 'PUT', headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(state.data.overrides)
      }).then(function () { toast('覆盖已删除'); render(); });
    };
    var tpl = $('#ovTemplate');
    if (tpl) tpl.onclick = function () {
      $('#ovBody').value = jsonPretty({ code: 0, message: '操作成功', data: { list: [], total: 0 } });
    };
  }

  function logsTable(limit) {
    if (!state.logs.length) return '<div class="empty"><div class="big">⌁</div>还没有请求<br>启动班牌并刷新首页后，这里会出现日志</div>';
    var rows = state.logs.slice(-limit).reverse();
    var html = '<table><thead><tr><th>时间</th><th>方法</th><th>路径</th><th>命中</th><th>耗时</th></tr></thead><tbody>';
    rows.forEach(function (l) {
      html += '<tr><td class="mono">' + esc(l.ts) + '</td><td><span class="method ' + esc(l.method) + '">' + esc(l.method) + '</span></td>' +
        '<td class="mono truncate">' + esc(l.path) + '</td><td><span class="tag-chip">' + esc(l.handler) + '</span></td><td class="mono">' + l.ms + 'ms</td></tr>';
    });
    html += '</tbody></table>';
    return html;
  }

  function clearLogs() {
    api('/api/logs/clear', { method: 'POST' }).then(function () {
      state.logs = []; state.logsSince = 0; toast('日志已清空'); render();
    });
  }

  function pollLogs() {
    api('/api/logs?since=' + state.logsSince).then(function (res) {
      if (res.items && res.items.length) {
        res.items.forEach(function (it) { state.logs.push(it); });
        if (state.logs.length > 400) state.logs = state.logs.slice(-400);
        state.logsSince = res.lastId;
        var dash = $('#dashLogs');
        if (state.view === 'dashboard') {
          var panel = $$('.panel').filter(function (p) { return p.textContent.indexOf('最近请求') >= 0; })[0];
          if (panel) {
            var body = panel.querySelector('.panel-body');
            if (body) body.innerHTML = logsTable(12);
          }
        }
        if (state.view === 'endpoints') {
          var p2 = $$('.panel').filter(function (p) { return p.textContent.indexOf('实时请求') >= 0; })[0];
          if (p2) { var b2 = p2.querySelector('.panel-body'); if (b2) b2.innerHTML = logsTable(40); }
        }
      }
    }).catch(function () {});
  }

  function manageLogPolling() {
    var should = state.view === 'dashboard' || state.view === 'endpoints';
    if (should && !state.logTimer) {
      state.logTimer = setInterval(pollLogs, 2000);
      pollLogs();
    } else if (!should && state.logTimer) {
      clearInterval(state.logTimer);
      state.logTimer = null;
    }
  }

  // ---------------------------------------------------------------------
  // device
  // ---------------------------------------------------------------------
  function viewDevice() {
    var srv = state.data.server;
    var base = 'http://' + srv.host;
    var lan = 'http://' + srv.lan + ':' + srv.port;
    var html = '<div class="grid-2"><div class="stack">';
    html += '<div class="panel"><div class="panel-head"><div><h3>连接地址</h3><p>把班牌或模拟器指向这些地址</p></div></div><div class="panel-body"><div class="stack">';
    html += urlCard('控制台（浏览器打开）', base + '/admin');
    html += urlCard('Android 模拟器', 'http://10.0.2.2:' + srv.port);
    html += urlCard('局域网真机', lan);
    html += '</div></div></div>';

    html += '<div class="panel"><div class="panel-head"><div><h3>接入步骤</h3><p>从源码到班牌显示</p></div></div><div class="panel-body"><div class="steps">';
    html += '<div class="step"><div><h4>构建云端调试包</h4><p>使用脚本把 APK 内的 <code class="mono">https://api.yyide.com</code> 替换成本控制器地址，并保留还原版的设备身份与快捷入口。</p>' +
      '<div class="code" style="margin-top:8px">./scripts/build-cloud-apk.ps1 -CloudUrl "http://10.0.2.2:' + srv.port + '"</div></div></div>';
    html += '<div class="step"><div><h4>卸载旧版并安装</h4><p>调试包使用 Android Debug 签名，不能覆盖原版。</p>' +
      '<div class="code" style="margin-top:8px">adb uninstall com.yd.android_brand_mvp\nadb install -r "dist/智慧班牌-3.0.14-云端版.apk"</div></div></div>';
    html += '<div class="step"><div><h4>登录</h4><p>账号 <b>demo</b>，密码 <b>demo</b>（任意账号也会返回演示数据）。</p></div></div>';
    html += '<div class="step"><div><h4>刷新首页</h4><p>回到首页或重启 App，云端布局、公告、相册立即生效。</p></div></div>';
    html += '</div></div></div>';

    html += '<div class="panel"><div class="panel-head"><div><h3>命令行速查</h3><p>模拟器 / 真机 / 日志</p></div>' +
      '<button class="btn small" id="btnCopyCmd">复制</button></div><div class="panel-body">' +
      '<div class="code" id="cmdBlock"># 端口转发（真机没有局域网时）\nadb reverse tcp:' + srv.port + ' tcp:' + srv.port + '\n\n# 重启应用\nadb shell am force-stop com.yd.android_brand_mvp\nadb shell monkey -p com.yd.android_brand_mvp 1\n\n# 看云端请求\ncurl http://127.0.0.1:' + srv.port + '/api/logs\n\n# 清除旧登录缓存（可选）\nadb shell pm clear com.yd.android_brand_mvp</div></div></div>';
    html += '</div>';

    html += '<div class="stack">';
    html += '<div class="panel"><div class="panel-head"><div><h3>组件巡展</h3><p>一键浏览全部 293 个首页组件</p></div></div><div class="panel-body">';
    html += '<p style="margin:0 0 12px;font-size:11.5px;line-height:1.7;color:#64748b">按 8×6 栅格把所有组件自动排成多页。班牌首页左右滑动即可逐页浏览，验证每个功能是否正常。</p>';
    html += '<div class="row"><button class="btn primary" id="btnMakeShowcase">生成巡展布局</button></div>';
    html += '<div class="meta-line" style="margin-top:10px">注意：会替换当前全部布局分页。</div>';
    html += '</div></div>';

    html += '<div class="panel"><div class="panel-head"><div><h3>演示身份</h3><p>服务端返回的班牌信息</p></div></div><div class="panel-body">';
    html += '<div class="list-row"><div class="info"><strong>' + esc(state.data.site.brand.brandName) + '</strong><span>' + esc(state.data.site.school.schoolName) + '</span></div><span class="tag-chip">' + esc(state.data.site.device.mac) + '</span></div>';
    html += '<div class="list-row"><div class="info"><strong>登录账号</strong><span>demo / demo</span></div><span class="tag-chip">任意账号</span></div>';
    html += '<div class="list-row"><div class="info"><strong>教师卡号</strong><span>8888888888 · 离线码 1145</span></div><span class="tag-chip">教师端</span></div>';
    html += '<div class="list-row"><div class="info"><strong>学生卡号</strong><span>1234567890 · 离线码 1024</span></div><span class="tag-chip">学生空间</span></div>';
    html += '</div></div>';

    html += '<div class="panel"><div class="panel-head"><div><h3>数据管理</h3><p>重置会恢复演示内容</p></div></div><div class="panel-body"><div class="row">' +
      '<button class="btn danger" id="btnResetAll2">恢复全部演示数据</button></div>' +
      '<div class="meta-line" style="margin-top:10px">布局、站点、内容、接口覆盖都会重置，操作不可撤销。</div></div></div>';
    html += '</div></div>';
    return html;
  }

  function urlCard(label, url) {
    return '<div class="url-card"><strong>' + esc(label) + '</strong><div class="row"><code>' + esc(url) + '</code>' +
      '<button class="btn small" data-copy="' + esc(url) + '" style="margin-left:auto">复制</button></div></div>';
  }

  function bindDevice() {
    $$('[data-copy]').forEach(function (b) { b.onclick = function () { copyText(b.dataset.copy); }; });
    var c = $('#btnCopyCmd'); if (c) c.onclick = function () { copyText($('#cmdBlock').textContent); };
    var ms = $('#btnMakeShowcase'); if (ms) ms.onclick = openShowcase;
    var r1 = $('#btnResetAll'); if (r1) r1.onclick = resetAll;
    var r2 = $('#btnResetAll2'); if (r2) r2.onclick = resetAll;
  }

  function resetAll() {
    if (!window.confirm('恢复全部演示数据？当前布局与内容会被覆盖。')) return;
    api('/api/reset', { method: 'POST' }).then(function () {
      toast('已恢复演示数据');
      loadState();
    });
  }

  function openShowcase() {
    var cats = state.catalog.categories || [];
    var counts = {};
    state.catalog.components.forEach(function (c) { counts[c.category] = (counts[c.category] || 0) + 1; });
    var body = '<p style="margin:0 0 12px;font-size:12px;color:#475569">选择要巡展的分类（不选则全部）。生成的每个分页会尽量排满 8×6。</p>';
    body += '<div class="row" style="gap:8px;margin-bottom:16px">';
    body += '<button class="pill" id="scAll">全选</button><button class="pill" id="scNone">全不选</button></div>';
    body += '<div style="display:grid;grid-template-columns:repeat(auto-fill,minmax(150px,1fr));gap:8px;max-height:40vh;overflow:auto">';
    cats.forEach(function (c) {
      if (!counts[c]) return;
      body += '<label class="check" style="border:1px solid #e4eaf4;border-radius:9px;padding:8px 10px">' +
        '<input type="checkbox" class="sc-cat" value="' + esc(c) + '" ' + (state.showcaseCats[c] !== false ? 'checked' : '') + '> ' + esc(c) +
        '<span style="margin-left:auto;color:#94a3b8;font-size:10px">' + counts[c] + '</span></label>';
    });
    body += '</div>';
    body += '<div class="field" style="margin-top:14px"><label>最多生成页数 <em>性能考虑，建议 10 页以内</em></label>' +
      '<input class="input" type="number" id="scMax" min="1" max="20" value="10"></div>';
    body += '<div class="meta-line">将替换当前全部布局分页。组件较多时请按分类分批生成。</div>';
    openModal('生成组件巡展', body,
      '<button class="btn" id="mCancel">取消</button><button class="btn primary" id="mGo">开始生成</button>', { wide: true });
    $('#mCancel').onclick = closeModal;
    $('#scAll').onclick = function () { $$('.sc-cat').forEach(function (x) { x.checked = true; }); };
    $('#scNone').onclick = function () { $$('.sc-cat').forEach(function (x) { x.checked = false; }); };
    $('#mGo').onclick = function () {
      var selected = $$('.sc-cat').filter(function (x) { return x.checked; }).map(function (x) { return x.value; });
      closeModal();
      var maxPages = parseInt($('#scMax') ? $('#scMax').value : 10, 10) || 10;
      api('/api/showcase', {
        method: 'POST', headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ categories: selected, replace: true, maxPages: maxPages })
      }).then(function (res) {
        var msg = '已生成 ' + res.pages + ' 页，共 ' + res.components + ' 个组件';
        if (res.skipped > 0) msg += '（另有 ' + res.skipped + ' 个未排入，建议按分类再生成）';
        toast(msg);
        state.pageIndex = 0;
        loadState().then(function () { setView('layout'); });
      }).catch(function (err) { toast('生成失败：' + err.message, 'err'); });
    };
  }

  // ---------------------------------------------------------------------
  // features
  // ---------------------------------------------------------------------
  function viewFeatures() {
    var acts = state.catalog.activities;
    var comps = state.catalog.components;
    var cats = {};
    comps.forEach(function (c) { cats[c.category] = (cats[c.category] || 0) + 1; });
    var q = state.activityQ.toLowerCase();
    var filtered = acts.filter(function (a) {
      return !q || (a.name + ' ' + a.short).toLowerCase().indexOf(q) >= 0;
    });
    var html = '<div class="grid-2"><div class="stack">';
    html += '<div class="panel"><div class="panel-head"><div><h3>Activity 功能入口</h3><p>' + acts.length + ' 个页面；导出的可直接用 adb 启动</p></div></div><div class="panel-body">';
    html += '<div class="search" style="margin-bottom:12px"><input class="input" id="featSearch" placeholder="搜索 Activity…" value="' + esc(state.activityQ) + '"></div>';
    html += '<div class="feature-grid" style="max-height:60vh;overflow:auto">';
    filtered.forEach(function (a) {
      var cmd = 'adb shell am start -n com.yd.android_brand_mvp/' + a.name;
      html += '<div class="feature"><div class="row"><strong style="flex:1">' + esc(a.short) + '</strong>' +
        '<span class="tag-chip" style="color:' + (a.exported ? '#0b8f63' : '#94a3b8') + '">' + (a.exported ? 'exported' : '内部') + '</span></div>' +
        '<div class="pkg">' + esc(a.package) + '</div>' +
        '<div class="cmd" title="' + esc(cmd) + '">' + esc(cmd) + '</div>' +
        '<div class="row" style="margin-top:8px"><button class="btn small" data-copy="' + esc(cmd) + '">复制启动命令</button></div></div>';
    });
    html += '</div></div></div>';
    html += '</div>';

    html += '<div class="stack">';
    html += '<div class="panel"><div class="panel-head"><div><h3>组件分类</h3><p>' + comps.length + ' 个首页组件</p></div></div><div class="panel-body">';
    Object.keys(cats).sort(function (a, b) { return cats[b] - cats[a]; }).forEach(function (c) {
      var p = Math.round(cats[c] / comps.length * 100);
      html += '<div style="margin-bottom:10px"><div class="row" style="justify-content:space-between;font-size:11px;margin-bottom:4px"><span>' + esc(c) + '</span><span style="color:#94a3b8">' + cats[c] + '</span></div>' +
        '<div style="height:5px;border-radius:4px;background:#eef3fb"><div style="height:100%;width:' + p + '%;background:#2f6bff;border-radius:4px"></div></div></div>';
    });
    html += '</div></div>';
    html += '<div class="panel"><div class="panel-head"><div><h3>如何浏览全部功能</h3></div></div><div class="panel-body">';
    html += '<div class="steps">';
    html += '<div class="step"><div><h4>首页组件</h4><p>组件库里 293 个组件都能放进布局，直接渲染对应 Fragment。用「生成组件巡展」一次排完。</p></div></div>';
    html += '<div class="step"><div><h4>独立 Activity</h4><p>上表导出页面可用 adb 启动；内部页面需从对应卡片进入。</p></div></div>';
    html += '<div class="step"><div><h4>深链与设置</h4><p>教师端 / 学生空间可用还原版的卡号与离线码快捷进入。</p></div></div>';
    html += '</div></div></div>';
    html += '</div></div>';
    return html;
  }

  function bindFeatures() {
    var s = $('#featSearch');
    if (s) s.oninput = function () { state.activityQ = s.value; render(); };
    $$('[data-copy]').forEach(function (b) { b.onclick = function () { copyText(b.dataset.copy); }; });
  }

  // ---------------------------------------------------------------------
  // modal
  // ---------------------------------------------------------------------
  function openModal(title, body, foot, opts) {
    $('#modalTitle').textContent = title;
    $('#modalBody').innerHTML = body;
    $('#modalFoot').innerHTML = foot || '';
    $('#modal').className = 'modal' + (opts && opts.wide ? ' wide' : '');
    $('#modalBackdrop').hidden = false;
  }
  function closeModal() { $('#modalBackdrop').hidden = true; }

  // ---------------------------------------------------------------------
  // bind
  // ---------------------------------------------------------------------
  function bindView() {
    $$('[data-go]').forEach(function (b) { b.onclick = function () { setView(b.dataset.go); }; });
    $$('[data-quick]').forEach(function (b) {
      b.onclick = function () {
        if (b.dataset.quick === 'showcase') openShowcase(); else setView(b.dataset.quick);
      };
    });
    $$('[data-page]').forEach(function (b) {
      b.onclick = function () { state.pageIndex = parseInt(b.dataset.page, 10); setView('layout'); };
    });
    if (state.view === 'layout') {
      bindBoard();
      bindInspector();
      $$('[data-pagetab]').forEach(function (b) {
        b.onclick = function (ev) {
          if (ev.target.dataset.delpage !== undefined) return;
          state.pageIndex = parseInt(b.dataset.pagetab, 10);
          state.selected = null;
          render();
        };
      });
      $$('[data-delpage]').forEach(function (x) {
        x.onclick = function (ev) { ev.stopPropagation(); deletePage(parseInt(x.dataset.delpage, 10)); };
      });
      var ap = $('#btnAddPage'); if (ap) ap.onclick = addPage;
      var ap2 = $('#btnAddPage2'); if (ap2) ap2.onclick = addPage;
      var rp = $('#btnRenamePage'); if (rp) rp.onclick = renamePage;
      var dp = $('#btnDupPage'); if (dp) dp.onclick = duplicatePage;
      var cp = $('#btnClearPage'); if (cp) cp.onclick = clearPage;
      var rl = $('#btnResetLayout'); if (rl) rl.onclick = function () {
        if (!window.confirm('恢复为默认的 7 张首页卡片？')) return;
        api('/api/layout/reset', { method: 'POST' }).then(function () {
          toast('已恢复默认布局'); state.pageIndex = 0; loadState();
        });
      };
    }
    if (state.view === 'library') {
      var ls = $('#libSearch');
      if (ls) ls.oninput = function () { state.library.q = ls.value; render(); };
      $$('[data-libcat]').forEach(function (b) { b.onclick = function () { state.library.category = b.dataset.libcat; render(); }; });
      $$('[data-libsize]').forEach(function (b) { b.onclick = function () { state.library.size = b.dataset.libsize; render(); }; });
      $$('[data-addtag]').forEach(function (b) { b.onclick = function () { addCard(b.dataset.addtag); }; });
      $$('[data-copytag]').forEach(function (b) { b.onclick = function () { copyText(b.dataset.copytag); }; });
    }
    if (state.view === 'content') bindContent();
    if (state.view === 'endpoints') bindEndpoints();
    if (state.view === 'device') bindDevice();
    if (state.view === 'features') bindFeatures();
  }

  // ---------------------------------------------------------------------
  // boot
  // ---------------------------------------------------------------------
  document.addEventListener('DOMContentLoaded', function () {
    $$('.nav-item').forEach(function (b) { b.onclick = function () { setView(b.dataset.view); }; });
    $('#modalClose').onclick = closeModal;
    $('#modalBackdrop').addEventListener('click', function (ev) { if (ev.target === $('#modalBackdrop')) closeModal(); });
    document.addEventListener('keydown', function (ev) {
      if ((ev.ctrlKey || ev.metaKey) && ev.key === 's') {
        ev.preventDefault();
        if (state.view === 'layout') saveLayout();
        else if (state.view === 'content') saveContent();
      }
      if (ev.key === 'Escape') closeModal();
    });
    loadState();
  });
})();
