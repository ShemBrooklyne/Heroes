document.addEventListener("DOMContentLoaded", function () {
  loadHeroes();
});

function loadHeroes() {
  fetch("http://localhost:8081/api/heroes/all")
    .then((response) => response.json())
    .then((data) => {
      const heroesList = document.getElementById("heroesList");
      heroesList.innerHTML = "";
      data.forEach((hero) => {
        const heroDiv = document.createElement("div");
        heroDiv.classList.add("hero");
        heroDiv.innerHTML = `
                    <strong>Name:</strong> ${hero.name}<br>
                    <strong>Alias:</strong> ${hero.alias}<br>
                    <strong>Superpower:</strong> ${hero.superPower}<br>
                    <button onclick="deleteHero(${hero.id})">Delete</button>
                    <button onclick="openUpdateForm(${hero.id})">Update</button>
                `;
        heroesList.appendChild(heroDiv);
      });
    })
    .catch((error) => console.error("Error:", error));
}

function createHero() {
  const name = document.getElementById("name").value;
  const alias = document.getElementById("alias").value;
  const superPower = document.getElementById("superPower").value;

  const heroData = {
    name: name,
    alias: alias,
    superPower: superPower,
  };

  fetch("http://localhost:8081/api/heroes/create", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(heroData),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Failed to create hero");
      }
      loadHeroes();
      document.getElementById("heroForm").reset();
    })
    .catch((error) => console.error("Error:", error));
}

function deleteHero(heroId) {
  fetch(`http://localhost:8081/api/heroes/delete/${heroId}`, {
    method: "DELETE",
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Failed to delete hero");
      }
      loadHeroes();
    })
    .catch((error) => console.error("Error:", error));
}

function openUpdateForm(heroId) {
  const heroData = prompt(
    "Enter updated hero data in JSON format:",
    '{"name": "", "alias": "", "superPower": ""}'
  );
  if (heroData) {
    fetch(`http://localhost:8081/api/heroes/update/${heroId}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: heroData,
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to update hero");
        }
        loadHeroes();
      })
      .catch((error) => console.error("Error:", error));
  }
}
