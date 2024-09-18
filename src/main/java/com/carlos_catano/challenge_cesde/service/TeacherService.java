package com.carlos_catano.challenge_cesde.service;

import com.carlos_catano.challenge_cesde.dto.TeacherDTO;
import com.carlos_catano.challenge_cesde.exception.ResourceNotFoundException;
import com.carlos_catano.challenge_cesde.model.Teacher;
import com.carlos_catano.challenge_cesde.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public TeacherDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));
        return convertToDTO(teacher);
    }

    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = convertToEntity(teacherDTO);
        return convertToDTO(teacherRepository.save(teacher));
    }

    public TeacherDTO updateTeacher(Long id, TeacherDTO teacherDTO) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));
        teacher.setName(teacherDTO.getName());
        teacher.setDocument(teacherDTO.getDocument());
        teacher.setEmail(teacherDTO.getEmail());
        return convertToDTO(teacherRepository.save(teacher));
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public List<TeacherDTO> findTeachersByName(String name) {
        return teacherRepository.findAll().stream()
                .filter(teacher -> teacher.getName().toLowerCase().contains(name.toLowerCase()))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TeacherDTO convertToDTO(Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacher.getId());
        teacherDTO.setName(teacher.getName());
        teacherDTO.setDocument(teacher.getDocument());
        teacherDTO.setEmail(teacher.getEmail());
        return teacherDTO;
    }

    private Teacher convertToEntity(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDTO.getName());
        teacher.setDocument(teacherDTO.getDocument());
        teacher.setEmail(teacherDTO.getEmail());
        return teacher;
    }
}
