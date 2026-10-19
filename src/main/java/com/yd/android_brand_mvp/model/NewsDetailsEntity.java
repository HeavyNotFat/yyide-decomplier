package com.yd.android_brand_mvp.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NewsDetailsEntity implements Serializable {
    private String body;
    private String[] css;
    private String ga_prefix;
    private String id;
    private String image;
    private String image_source;
    private String[] js;
    private List<Recommender> recommenders;
    private Section section;
    private String share_url;
    private String title;
    private String type;

    public String getBody() {
        return this.body;
    }

    public String getImage_source() {
        return this.image_source;
    }

    public String getTitle() {
        return this.title;
    }

    public String getImage() {
        return this.image;
    }

    public String getShare_url() {
        return this.share_url;
    }

    public String getGa_prefix() {
        return this.ga_prefix;
    }

    public String getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    public String[] getJs() {
        return this.js;
    }

    public String[] getCss() {
        return this.css;
    }

    public List<Recommender> getRecommenders() {
        return this.recommenders;
    }

    public Section getSection() {
        return this.section;
    }

    public class Recommender implements Serializable {
        private String avatar;

        public Recommender() {
        }

        public String getAvatar() {
            return this.avatar;
        }

        public String toString() {
            return "Recommender{avatar='" + this.avatar + "'}";
        }
    }

    public class Section implements Serializable {
        private String id;
        private String name;
        private String thumbnail;

        public Section() {
        }

        public String getThumbnail() {
            return this.thumbnail;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "Section{thumbnail='" + this.thumbnail + "', id='" + this.id + "', name='" + this.name + "'}";
        }
    }

    public String toString() {
        return "News{body='" + this.body + "', image_source='" + this.image_source + "', title='" + this.title + "', image='" + this.image + "', share_url='" + this.share_url + "', ga_prefix='" + this.ga_prefix + "', type='" + this.type + "', id='" + this.id + "', js=" + Arrays.toString(this.js) + ", css=" + Arrays.toString(this.css) + ", recommenders=" + this.recommenders + ", section=" + this.section + '}';
    }
}
