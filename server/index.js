const express = require('express');

const app = express();

app.use(express.json())


// input: body { discordTag, password }

app.get("/login", (req, res) => {

    // check if user is in the database

    res.send({ message: "Add user"});
});

app.get("/users/remove", (req, res) => {


    res.send({ message: "Remove user"});
});

app.listen(3000, () => console.log("Hamegululu"));