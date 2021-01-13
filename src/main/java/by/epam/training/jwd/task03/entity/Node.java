package by.epam.training.jwd.task03.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
	
	private String name;
	private List<Attribute> attributes;
	private List<Node> childNodes;
	private String content;

	private Node(){}

	public static Builder newBuilder(){
		return new Node().new Builder();
	}


	public void addAtrribute(Attribute attribute){
		if (attributes == null) {
			attributes = new ArrayList<>();
		}
		attributes.add(attribute);
	}

	public void addChild(Node child){
		if (childNodes == null){
			childNodes = new ArrayList<>();
		}
		childNodes.add(child);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Attribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	public List<Node> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<Node> childNodes) {
		this.childNodes = childNodes;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (null == obj) { return false; }
        if (getClass() != obj.getClass()) { return false; }

        Node node = (Node)obj;
        if (null == name) {
			return name == node.name;
		} else if (null == attributes) {
        	return attributes == node.attributes;
		} else if (null == childNodes) {
        	return childNodes == node.childNodes;
		} else if (null == content) {
        	return content == node.content;
		} else {
        	if (!name.equals(node.name)) { return false; }
        	else if (!attributes.equals(node.attributes)) {return false; }
        	else if (!childNodes.equals(node.childNodes)) {return false; }
        	else if (!content.equals(node.content)) {return false; }
		}
        return true;
    }

    @Override
    public int hashCode() {
		int result = 1;
        return (31 * result + (null == name ? 0 : name.hashCode()) +
				31 * result + (null == attributes ? 0: attributes.hashCode()) +
				31 * result + (null == childNodes ? 0 : childNodes.hashCode()) +
				31 * result + (null == content ? 0 : content.hashCode()));
    }

    @Override
	public String toString() {
		return "Node{" +
				"name='" + name + '\'' +
				", attributes=" + attributes +
				", childNodes=" + childNodes +
				", content='" + content + '\'' +
				'}';
	}

	public class Builder {

		private Builder(){}


		public Builder withName(String name) {
			Node.this.name = name;
			return this;
		}

		public Builder withContent(String content) {
			Node.this.content = content;
			return this;
		}

		public Builder withChildren(List<Node> children) {
			Node.this.childNodes = children;
			return this;
		}

		public Builder withAttributes(List<Attribute> attributes) {
			Node.this.attributes = attributes;
			return this;
		}

		public Node build() {
			return Node.this;
		}
	}
}
