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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Node)) return false;
		Node node = (Node) o;
		return Objects.equals(getName(), node.getName()) &&
				Objects.equals(getAttributes(), node.getAttributes()) &&
				Objects.equals(getChildNodes(), node.getChildNodes()) &&
				Objects.equals(getContent(), node.getContent());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getAttributes(), getChildNodes(), getContent());
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
