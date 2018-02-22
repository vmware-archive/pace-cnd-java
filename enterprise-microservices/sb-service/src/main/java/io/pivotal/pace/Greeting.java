package io.pivotal.pace;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String language;
  private String text;

  public Greeting(String language, String text) {
    super();
    this.language = language;
    this.text = text;
  }

  @Override
  public String toString() {
    return "Greeting [id=" + id + ", language=" + language + ", text=" + text + "]";
  }

  public Integer getId() {
	    return id;
	  }

  public String getLanguage() {
    return language;
  }

  public String getText() {
	    return text;
	  }

  public Greeting() {}
}
