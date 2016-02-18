package br.org.ismart.ismartonline.models;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.ClassInfo;
import com.google.api.services.classroom.model.Course;

@XmlRootElement
public class IsmartCourse  {
	
	private Course course;

	public IsmartCourse(Course course) {
		this.course = course;
	}

	public final JsonFactory getFactory() {
		return course.getFactory();
	}

	public final void setFactory(JsonFactory factory) {
		course.setFactory(factory);
	}

	public String toString() {
		return course.toString();
	}

	public int size() {
		return course.size();
	}

	public String toPrettyString() throws IOException {
		return course.toPrettyString();
	}

	public boolean isEmpty() {
		return course.isEmpty();
	}

	public final Object get(Object name) {
		return course.get(name);
	}

	public boolean containsValue(Object value) {
		return course.containsValue(value);
	}

	public final Object put(String fieldName, Object value) {
		return course.put(fieldName, value);
	}

	public boolean containsKey(Object key) {
		return course.containsKey(key);
	}

	public final void putAll(Map<? extends String, ?> map) {
		course.putAll(map);
	}

	public final Object remove(Object name) {
		return course.remove(name);
	}

	public Set<Entry<String, Object>> entrySet() {
		return course.entrySet();
	}

	public String getAlternateLink() {
		return course.getAlternateLink();
	}

	public final Map<String, Object> getUnknownKeys() {
		return course.getUnknownKeys();
	}

	public Course setAlternateLink(String alternateLink) {
		return course.setAlternateLink(alternateLink);
	}

	public final void setUnknownKeys(Map<String, Object> unknownFields) {
		course.setUnknownKeys(unknownFields);
	}

	public String getCourseState() {
		return course.getCourseState();
	}

	public final ClassInfo getClassInfo() {
		return course.getClassInfo();
	}

	public Course setCourseState(String courseState) {
		return course.setCourseState(courseState);
	}

	public String getCreationTime() {
		return course.getCreationTime();
	}

	public Course setCreationTime(String creationTime) {
		return course.setCreationTime(creationTime);
	}

	public String getDescription() {
		return course.getDescription();
	}

	public Course setDescription(String description) {
		return course.setDescription(description);
	}

	public String getDescriptionHeading() {
		return course.getDescriptionHeading();
	}

	public Course setDescriptionHeading(String descriptionHeading) {
		return course.setDescriptionHeading(descriptionHeading);
	}

	public String getEnrollmentCode() {
		return course.getEnrollmentCode();
	}

	public Course setEnrollmentCode(String enrollmentCode) {
		return course.setEnrollmentCode(enrollmentCode);
	}

	public String getId() {
		return course.getId();
	}

	public void clear() {
		course.clear();
	}

	public Course setId(String id) {
		return course.setId(id);
	}

	public Set<String> keySet() {
		return course.keySet();
	}

	public String getName() {
		return course.getName();
	}

	public Course setName(String name) {
		return course.setName(name);
	}

	public String getOwnerId() {
		return course.getOwnerId();
	}

	public Course setOwnerId(String ownerId) {
		return course.setOwnerId(ownerId);
	}

	public Collection<Object> values() {
		return course.values();
	}

	public String getRoom() {
		return course.getRoom();
	}

	public Course setRoom(String room) {
		return course.setRoom(room);
	}

	public String getSection() {
		return course.getSection();
	}

	public Course setSection(String section) {
		return course.setSection(section);
	}

	public String getUpdateTime() {
		return course.getUpdateTime();
	}

	public Course setUpdateTime(String updateTime) {
		return course.setUpdateTime(updateTime);
	}

	public Course set(String fieldName, Object value) {
		return course.set(fieldName, value);
	}

	public Course clone() {
		return course.clone();
	}

	public boolean equals(Object o) {
		return course.equals(o);
	}

	public int hashCode() {
		return course.hashCode();
	}


}
