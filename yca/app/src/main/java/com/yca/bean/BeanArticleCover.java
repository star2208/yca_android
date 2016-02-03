package com.yca.bean;

public class BeanArticleCover extends BaseBean{

	private static final long serialVersionUID = -2321128825035943349L;
    public int id;
    public String title;
    public String cover;
    public int style;
    public String describe;
    public String publishTime;
    public BeanTopic topic;
    public BeanAuthor author;
}
