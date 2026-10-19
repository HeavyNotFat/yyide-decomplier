package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NewsEntity {
    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public List<StoriesBean> getStories() {
        return this.stories;
    }

    public void setStories(List<StoriesBean> list) {
        this.stories = list;
    }

    public List<TopStoriesBean> getTop_stories() {
        return this.top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> list) {
        this.top_stories = list;
    }

    public static class StoriesBean {
        private String ga_prefix;
        private int id;
        private List<String> images;
        private String title;
        private int type;

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int i) {
            this.id = i;
        }

        public String getGa_prefix() {
            return this.ga_prefix;
        }

        public void setGa_prefix(String str) {
            this.ga_prefix = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public List<String> getImages() {
            return this.images;
        }

        public void setImages(List<String> list) {
            this.images = list;
        }
    }

    public static class TopStoriesBean {
        private String ga_prefix;
        private int id;
        private String image;
        private String title;
        private int type;

        public String getImage() {
            return this.image;
        }

        public void setImage(String str) {
            this.image = str;
        }

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int i) {
            this.id = i;
        }

        public String getGa_prefix() {
            return this.ga_prefix;
        }

        public void setGa_prefix(String str) {
            this.ga_prefix = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }
}
