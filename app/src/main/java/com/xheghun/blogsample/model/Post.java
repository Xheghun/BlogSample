package com.xheghun.blogsample.model;

public class Post {
   private String title;
   private String readDuration;
   private String authorName;
   private String tag;
   private int coverImage;
   private int authorPicture;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReadDuration() {
        return readDuration;
    }

    public void setReadDuration(String readDuration) {
        this.readDuration = readDuration;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(int coverImage) {
        this.coverImage = coverImage;
    }

    public int getAuthorPicture() {
        return authorPicture;
    }

    public void setAuthorPicture(int authorPicture) {
        this.authorPicture = authorPicture;
    }
}
