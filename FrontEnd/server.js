const express = require('express');
const frontEnd = express();

frontEnd.use(express.static(__dirname + '/dist'));
frontEnd.listen(process.env.PORT || 8080);
