package br.org.ismart.ismartonline.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.classroom.ClassroomScopes;
import com.google.api.services.classroom.model.Course;
import com.google.api.services.classroom.model.ListCoursesResponse;

import br.org.ismart.ismartonline.models.IsmartCourse;

@Component
public class GoogleClassroomClient {

	
	  /** Application name. */
    private static final String APPLICATION_NAME =
        "Classroom API Java Quickstart";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), ".credentials/classroom-java-quickstart");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart. */
    private static final List<String> SCOPES =
        Arrays.asList(ClassroomScopes.CLASSROOM_COURSES_READONLY);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in =
            GoogleClassroomClient.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets =
            GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("online")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
            flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Classroom client service.
     * @return an authorized Classroom client service
     * @throws IOException
     */
    public static com.google.api.services.classroom.Classroom
            getClassroomService() throws IOException {
        Credential credential = authorize();
        return new com.google.api.services.classroom.Classroom.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void main(String[] args) throws IOException {
    	
        // Build a new authorized API client service.
        com.google.api.services.classroom.Classroom service =
            getClassroomService();

        // List the first 10 courses that the user has access to.
        ListCoursesResponse response = service.courses().list()
            .setPageSize(10)
            .execute();
        List<Course> courses = response.getCourses();
        if (courses == null || courses.size() == 0) {
            System.out.println("No courses found.");
        } else {
            System.out.println("Courses:");
            for (Course course : courses) {
                System.out.printf("%s\n", course.getName());
            }
        }
    }

	
	
	public List<IsmartCourse> getCourses() throws IOException{
		
		
		 // Build a new authorized API client service.
        com.google.api.services.classroom.Classroom service = GoogleClassroomClient.getClassroomService();

        // List the first 10 courses that the user has access to.
        
        
        ListCoursesResponse response = service.courses().list()
            .setPageSize(10)
            .execute();
        
        List<Course> courses = response.getCourses();
        List<IsmartCourse> ismartCourses = new ArrayList<>();
        
        if (courses == null || courses.size() == 0) {
            System.out.println("No courses found.");
            return Collections.emptyList();
        } else {
            System.out.println("Courses:");
            for (Course course : courses) {
            	IsmartCourse ismartCourse = new IsmartCourse(course);
            	ismartCourses.add(ismartCourse);
                System.out.printf("%s\n", course.getName());
            }
            return ismartCourses;
        }
		
	}
	
	

}
