package com.kosify.car_shop_api.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "inspection_result")
public class InspectionResult {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UUID inspector_id;
	
	@OneToOne(targetEntity = Car.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	private UUID car_id;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date inspection_date;
	
	private boolean break_checked = false;
	private String break_comment;
	
	private boolean tire_checked = false;
	private String tire_comment;
	
	private boolean lights_checked = false;
	private String lights_comment;
	
	private boolean oil_changed = false;
	private String oil_comment;
	
	private boolean break_fluid_checked = false;
	private String break_fluid_comment;
	
	private boolean window_fluid_checked = false;
	private String window_fluid_comment;
	
	private boolean wipers_checked = false;
	private String wipers_comment;
	
	private boolean air_filter_checked = false;
	private String air_filter_comment;
	
	private String additional_comments;

	
	public InspectionResult(UUID inspector_id, UUID car_id, Date inspection_date, boolean break_checked,
			String break_comment, boolean tire_checked, String tire_comment, boolean lights_checked,
			String lights_comment, boolean oil_changed, String oil_comment, boolean break_fluid_checked,
			String break_fluid_comment, boolean window_fluid_checked, String window_fluid_comment,
			boolean wipers_checked, String wipers_comment, boolean air_filter_checked, String air_filter_comment,
			String additional_comments) {
		super();
		this.inspector_id = inspector_id;
		this.car_id = car_id;
		this.inspection_date = inspection_date;
		this.break_checked = break_checked;
		this.break_comment = break_comment;
		this.tire_checked = tire_checked;
		this.tire_comment = tire_comment;
		this.lights_checked = lights_checked;
		this.lights_comment = lights_comment;
		this.oil_changed = oil_changed;
		this.oil_comment = oil_comment;
		this.break_fluid_checked = break_fluid_checked;
		this.break_fluid_comment = break_fluid_comment;
		this.window_fluid_checked = window_fluid_checked;
		this.window_fluid_comment = window_fluid_comment;
		this.wipers_checked = wipers_checked;
		this.wipers_comment = wipers_comment;
		this.air_filter_checked = air_filter_checked;
		this.air_filter_comment = air_filter_comment;
		this.additional_comments = additional_comments;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getInspector_id() {
		return inspector_id;
	}

	public void setInspector_id(UUID inspector_id) {
		this.inspector_id = inspector_id;
	}

	public UUID getCar_id() {
		return car_id;
	}

	public void setCar_id(UUID car_id) {
		this.car_id = car_id;
	}

	public Date getInspection_date() {
		return inspection_date;
	}

	public void setInspection_date(Date inspection_date) {
		this.inspection_date = inspection_date;
	}

	public boolean isBreak_checked() {
		return break_checked;
	}

	public void setBreak_checked(boolean break_checked) {
		this.break_checked = break_checked;
	}

	public String getBreak_comment() {
		return break_comment;
	}

	public void setBreak_comment(String break_comment) {
		this.break_comment = break_comment;
	}

	public boolean isTire_checked() {
		return tire_checked;
	}

	public void setTire_checked(boolean tire_checked) {
		this.tire_checked = tire_checked;
	}

	public String getTire_comment() {
		return tire_comment;
	}

	public void setTire_comment(String tire_comment) {
		this.tire_comment = tire_comment;
	}

	public boolean isLights_checked() {
		return lights_checked;
	}

	public void setLights_checked(boolean lights_checked) {
		this.lights_checked = lights_checked;
	}

	public String getLights_comment() {
		return lights_comment;
	}

	public void setLights_comment(String lights_comment) {
		this.lights_comment = lights_comment;
	}

	public boolean isOil_changed() {
		return oil_changed;
	}

	public void setOil_changed(boolean oil_changed) {
		this.oil_changed = oil_changed;
	}

	public String getOil_comment() {
		return oil_comment;
	}

	public void setOil_comment(String oil_comment) {
		this.oil_comment = oil_comment;
	}

	public boolean isBreak_fluid_checked() {
		return break_fluid_checked;
	}

	public void setBreak_fluid_checked(boolean break_fluid_checked) {
		this.break_fluid_checked = break_fluid_checked;
	}

	public String getBreak_fluid_comment() {
		return break_fluid_comment;
	}

	public void setBreak_fluid_comment(String break_fluid_comment) {
		this.break_fluid_comment = break_fluid_comment;
	}

	public boolean isWindow_fluid_checked() {
		return window_fluid_checked;
	}

	public void setWindow_fluid_checked(boolean window_fluid_checked) {
		this.window_fluid_checked = window_fluid_checked;
	}

	public String getWindow_fluid_comment() {
		return window_fluid_comment;
	}

	public void setWindow_fluid_comment(String window_fluid_comment) {
		this.window_fluid_comment = window_fluid_comment;
	}

	public boolean isWipers_checked() {
		return wipers_checked;
	}

	public void setWipers_checked(boolean wipers_checked) {
		this.wipers_checked = wipers_checked;
	}

	public String getWipers_comment() {
		return wipers_comment;
	}

	public void setWipers_comment(String wipers_comment) {
		this.wipers_comment = wipers_comment;
	}

	public boolean isAir_filter_checked() {
		return air_filter_checked;
	}

	public void setAir_filter_checked(boolean air_filter_checked) {
		this.air_filter_checked = air_filter_checked;
	}

	public String getAir_filter_comment() {
		return air_filter_comment;
	}

	public void setAir_filter_comment(String air_filter_comment) {
		this.air_filter_comment = air_filter_comment;
	}

	public String getAdditional_comments() {
		return additional_comments;
	}

	public void setAdditional_comments(String additional_comments) {
		this.additional_comments = additional_comments;
	}
	
	
}
