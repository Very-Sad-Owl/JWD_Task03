package by.epam.training.jwd.task03.entity;

import java.util.Objects;

public class Attribute {
	private String name;
	private String content;

	public Attribute(){}

	public Attribute(String name, String content) {
		this.name = name;
		this.content = content;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

		Attribute attribute = (Attribute) obj;
		if (null == name) {
			return name == attribute.name;
		} else if (null == content) {
			return content == attribute.content;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		return (31 * result + (null == name ? 0 : name.hashCode()) +
				31 * result + (null == content ? 0: content.hashCode()));
	}

	@Override
	public String toString() {
		return "Attribute{" +
				"name='" + name + '\'' +
				", content='" + content + '\'' +
				'}';
	}

}
