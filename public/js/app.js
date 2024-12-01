document.addEventListener("DOMContentLoaded", () => {
    const API_URL = "http://localhost:8080/api/v1";
    const testMode = true;

    // Fetch data from JSON
    async function fetchData(url) {
        try {
            const response = await fetch(url);
            if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
            return await response.json();
        } catch (error) {
            console.error("Error fetching data:", error);
            return [];
        }
    }

    // Render "About Me" Section
    async function renderAbout() {
        const data = await fetchData("./json/about.json"); // Load from local JSON for now
        const aboutContent = document.getElementById("aboutContent");
        aboutContent.innerHTML = `
            <img src="${data.photo}" alt="${data.name}">
            <h3>${data.name}</h3>
            <p>${data.profession}</p>
            <p>${data.description}</p>
        `;
    }

    // Render Projects Section
    let currentPage = 0;

    async function renderProjects() {
        const projects = await fetchData(`${API_URL}/projects?page=${currentPage}`);
        const projectCards = document.getElementById("projectCards");
        projectCards.innerHTML = projects
            .map((project) =>
                createProjectCard(project, testMode)
            )
            .join("");

        document.getElementById("prevPage").disabled = currentPage === 0;
        document.getElementById("nextPage").disabled = projects.length === 0;
    }

    function createProjectCard(project, test = false) {
        return `
            <div class="project-card">
                <h3>${project.projectName}</h3>
                <p>${project.description}</p>
                <a href="${project.repositoryUrl}" target="_blank">Repository</a>
                <a href="${project.demoUrl}" target="_blank">Demo</a>
                ${test ? `<button onclick="deleteProject(${project.projectId})">Delete</button>` : ""}
            </div>
        `;
    }

    // Delete Project
    async function deleteProject(id) {
        try {
            const response = await fetch(`${API_URL}/projects/${id}`, { method: "DELETE" });
            if (!response.ok) throw new Error("Failed to delete project.");
            alert("Project deleted successfully.");
            renderProjects();
        } catch (error) {
            console.error("Error deleting project:", error);
        }
    }

    const searchField = document.getElementById("projectSearch");
    const searchButton = document.getElementById("searchButton");

    // Función para buscar proyectos
    const searchProjects = async (query) => {
        try {
            const url = query ? `${API_URL}/projects/${query}` : `${API_URL}/projects`;
            const projects = await fetchData(url);
            renderProjects(projects.content);
        } catch (error) {
            console.error("Error fetching projects:", error);
        }
    };

    // Listener para el botón de búsqueda
    searchButton.addEventListener("click", () => {
        const query = searchField.value.trim();
        if (query.length >= 3) {
            searchProjects(query);
        } else if (query === "") {
            // Si el campo de búsqueda está vacío, recargar todos los proyectos
            searchProjects();
        } else {
            alert("Please enter at least 3 characters to search.");
        }
    });

    // Listener para detectar si el campo queda vacío
    searchField.addEventListener("input", () => {
        if (searchField.value.trim() === "") {
            searchProjects(); // Recargar todos los proyectos
        }
    });


    document.getElementById("prevPage").addEventListener("click", () => {
        if (currentPage > 0) {
            currentPage--;
            renderProjects();
        }
    });

    document.getElementById("nextPage").addEventListener("click", () => {
        currentPage++;
        renderProjects();
    });

    // Render Everything on Page Load
    renderAbout();
    renderProjects();
});