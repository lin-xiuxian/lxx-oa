package com.lxx.oa.entity;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public class Node {
    private Long nodeId;
    private Integer nodeType; //节点类型 1-模块 2-功能
    private String nodeName; //节点名
    private String url; //页面URL
    private Long parentId; //上级编号

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
