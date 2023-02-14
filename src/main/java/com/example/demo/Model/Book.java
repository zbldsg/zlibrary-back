package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //添加日期
    @Column(nullable = false, columnDefinition = "Text")
    private String dateAdded;

    //修改日期
    @Column(nullable = false, columnDefinition = "Text")
    private String dateModified;

    //扩展名(格式)
    @Column(nullable = false, columnDefinition = "Text")
    private String extension;

    //文件大小
    @Column(nullable = false)
    private Long filesize;

    //报告的文件大小
    @Column(nullable = false)
    private Long filesizeReported;

    //md5
    @Column(nullable = false, columnDefinition = "char")
    private String md5;

    //md5报告
    @Column(nullable = false, columnDefinition = "char")
    private String md5_reported;

    //名称
    @Column(nullable = false, columnDefinition = "Text")
    private String title;

    //作者
    @Column(nullable = false, columnDefinition = "Text")
    private String author;

    //出版社
    @Column(nullable = false, columnDefinition = "Text")
    private String publisher;

    //语言
    @Column(nullable = false, columnDefinition = "Text")
    private String language;

    //系列
    @Column(nullable = false, columnDefinition = "Text")
    private String series;

    //册(集)
    @Column(nullable = false, columnDefinition = "Text")
    private String volume;

    //编辑
    @Column(nullable = false, columnDefinition = "Text")
    private String edition;

    //年份
    @Column(nullable = false, columnDefinition = "Text")
    private String year;

    //页数
    @Column(nullable = false, columnDefinition = "Text")
    private String pages;

    //描述
    @Column(nullable = false, columnDefinition = "Text")
    private String description;

    //封面URL
    @Column(nullable = false, columnDefinition = "Text")
    private String coverUrl;

    //
    @Column(nullable = false, columnDefinition = "tinyint")
    private Integer inLibgen;

    //所属的 pilimi 种子
    private String pilimiTorrent;

    //不可用
    @Column(nullable = false, columnDefinition = "tinyint")
    private Integer unavailable;
}
