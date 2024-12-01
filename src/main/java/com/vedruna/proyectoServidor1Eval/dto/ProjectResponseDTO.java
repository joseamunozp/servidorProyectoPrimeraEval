// src/main/java/com/example/developer/dto/ProjectResponseDTO.java
package com.vedruna.proyectoServidor1Eval.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.vedruna.proyectoServidor1Eval.dto.ProjectResponseDTO.DeveloperResponseDTO;
import com.vedruna.proyectoServidor1Eval.dto.ProjectResponseDTO.TechnologyResponseDTO;
import com.vedruna.proyectoServidor1Eval.persistanse.model.Project;

public class ProjectResponseDTO {

    private Integer projectId;
    private String projectName;
    private String description;
    private Date startDate;
    private Date endDate;
    private String repositoryUrl;
    private String demoUrl;
    private String picture;
    private StatusResponseDTO status;
    private List<TechnologyResponseDTO> technologies;
    private List<DeveloperResponseDTO> developers;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public StatusResponseDTO getStatus() {
        return status;
    }

    public void setStatus(StatusResponseDTO status) {
        this.status = status;
    }

    public List<TechnologyResponseDTO> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyResponseDTO> technologies) {
        this.technologies = technologies;
    }

    public List<DeveloperResponseDTO> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<DeveloperResponseDTO> developers) {
        this.developers = developers;
    }

    // Subclases internas para Status, Technology y Developer

    public static class StatusResponseDTO {
        private Integer statusId;
        private String statusName;

        public Integer getStatusId() {
            return statusId;
        }

        public void setStatusId(Integer statusId) {
            this.statusId = statusId;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }
    }

    public static class TechnologyResponseDTO {
        private Integer techId;
        private String techName;

        public Integer getTechId() {
            return techId;
        }

        public void setTechId(Integer techId) {
            this.techId = techId;
        }

        public String getTechName() {
            return techName;
        }

        public void setTechName(String techName) {
            this.techName = techName;
        }
    }

    public static class DeveloperResponseDTO {
        private Integer devId;
        private String devName;
        private String devSurname;

        public Integer getDevId() {
            return devId;
        }

        public void setDevId(Integer devId) {
            this.devId = devId;
        }

        public String getDevName() {
            return devName;
        }

        public void setDevName(String devName) {
            this.devName = devName;
        }

        public String getDevSurname() {
            return devSurname;
        }

        public void setDevSurname(String devSurname) {
            this.devSurname = devSurname;
        }
    }
}
