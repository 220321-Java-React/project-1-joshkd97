package com.revature.models;

public class Reimbursement {
	
	private int reimb_id;
	private int amount;
	private String time_submitted;
	private String time_resolved;
	private String description;
	private User author;
	private User resolver;
	private ReimbStatus status;
	private ReimbType type;
	
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimbursement(int reimb_id, int amount, String time_submitted, String time_resolved, String description,
			User author, User resolver, ReimbStatus status, ReimbType type) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.time_submitted = time_submitted;
		this.time_resolved = time_resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	
	


	public Reimbursement(int amount, String time_submitted, String time_resolved, String description, User author,
			User resolver, ReimbStatus status, ReimbType type) {
		super();
		this.amount = amount;
		this.time_submitted = time_submitted;
		this.time_resolved = time_resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}


	public int getReimb_id() {
		return reimb_id;
	}


	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getTime_submitted() {
		return time_submitted;
	}


	public void setTime_submitted(String time_submitted) {
		this.time_submitted = time_submitted;
	}


	public String getTime_resolved() {
		return time_resolved;
	}


	public void setTime_resolved(String time_resolved) {
		this.time_resolved = time_resolved;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
		this.author = author;
	}


	public User getResolver() {
		return resolver;
	}


	public void setResolver(User resolver) {
		this.resolver = resolver;
	}


	public ReimbStatus getStatus() {
		return status;
	}


	public void setStatus(ReimbStatus status) {
		this.status = status;
	}


	public ReimbType getType() {
		return type;
	}


	public void setType(ReimbType type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", amount=" + amount + ", time_submitted=" + time_submitted
				+ ", time_resolved=" + time_resolved + ", description=" + description + ", author=" + author
				+ ", resolver=" + resolver + ", status=" + status + ", type=" + type + "]";
	}
	
	
	
	
}
