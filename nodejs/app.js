const express = require('express')
const axios = require('axios');
const app = express()
const config = require('./config.json');
const port = 3001

app.use(express.json());
app.use('/static', express.static('public'))

app.get('/hi', (req, res) => {
  res.json({msg: 'Hello World!', baseUrl: config.externalApiBaseUrl})
})


app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})