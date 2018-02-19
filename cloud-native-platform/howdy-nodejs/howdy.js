const express = require('express');
const cfEnv = require('cfenv');

const app = express();
const appEnv = cfEnv.getAppEnv();
const host = appEnv.bind;
const port = appEnv.port;

app.use(express.json());

app.get('/howdy', function(req, res) {
    res.send(appEnv);
});

app.post('/echo', function(req, res) {
    var body = req.body;
    console.log(body);
    res.send(body);
});

app.listen(port, function() {
    console.log(`Server running at ${host}:${port}, ${appEnv.url}`);
});
