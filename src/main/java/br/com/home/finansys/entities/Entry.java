package br.com.home.finansys.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entry")
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "paid")
	private String paid;
	@Column(name = "date")
	private String date;
	@Column(name = "amount")
	private String amount;
	@Column(name = "type")
	private String type;

	@OneToOne( )
	private Category category;

	public Entry() {

	}


	/***
	 *  Não pode existir lançamento sem informar a categoria ao qual pertence
	 * @param id
	 * @param name
	 * @param description
	 * @param paid
	 * @param date
	 * @param amount
	 * @param type
	 * @param category
	 */
	public Entry(Long id, String name, String description, String paid, String date, String amount, String type, Category category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.paid = paid;
		this.date = date;
		this.amount = amount;
		this.type = type;
		this.category = category;
	}


   
/*  Getters and Setters 
	(command) + shift + p  */
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPaid() {
		return this.paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

}
