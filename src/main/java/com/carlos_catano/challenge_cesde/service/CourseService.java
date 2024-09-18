package com.carlos_catano.challenge_cesde.service;

import com.carlos_catano.challenge_cesde.dto.CourseDTO;
import com.carlos_catano.challenge_cesde.exception.ResourceNotFoundException;
import com.carlos_catano.challenge_cesde.model.Course;
import com.carlos_catano.challenge_cesde.model.Teacher;
import com.carlos_catano.challenge_cesde.repository.CourseRepository;
import com.carlos_catano.challenge_cesde.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        return convertToDTO(course);
    }

    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = convertToEntity(courseDTO);
        return convertToDTO(courseRepository.save(course));
    }

    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setDuration(courseDTO.getDuration());
        course.setPrice(courseDTO.getPrice());
        course.setStartDate(courseDTO.getStartDate());

        Teacher teacher = teacherRepository.findById(courseDTO.getTeacherId())
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));
        course.setTeacher(teacher);

        return convertToDTO(courseRepository.save(course));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<CourseDTO> filterCourses(String name, BigDecimal price) {
        return courseRepository.findAll().stream()
                .filter(course ->
                        (name == null || course.getName().contains(name)) &&
                                (price == null || course.getPrice().compareTo(price) <= 0)
                )
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CourseDTO convertToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setDuration(course.getDuration());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setStartDate(course.getStartDate());
        courseDTO.setTeacherId(course.getTeacher().getId());
        return courseDTO;
    }

    private Course convertToEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setDuration(courseDTO.getDuration());
        course.setPrice(courseDTO.getPrice());
        course.setStartDate(courseDTO.getStartDate());

        Teacher teacher = teacherRepository.findById(courseDTO.getTeacherId())
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));
        course.setTeacher(teacher);

        return course;
    }
}
