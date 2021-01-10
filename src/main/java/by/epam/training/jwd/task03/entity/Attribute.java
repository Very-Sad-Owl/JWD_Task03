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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Attribute)) return false;
		Attribute attribute = (Attribute) o;
		return Objects.equals(getName(), attribute.getName()) &&
				Objects.equals(getContent(), attribute.getContent());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getContent());
	}

	@Override
	public String toString() {
		return "Attribute{" +
				"name='" + name + '\'' +
				", content='" + content + '\'' +
				'}';
	}

}
