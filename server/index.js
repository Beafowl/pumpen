const express = require('express');

const app = express();

app.use(express.json())

app.get("/users/getUser", (req, res) => {


    res.send({ message: "Add user"});
});

app.get("/users/remove", (req, res) => {


    res.send({ message: "Remove user"});
});

app.listen(3000, () => console.log("Hamegululu"));