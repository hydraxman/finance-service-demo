const express = require('express')
const axios = require('axios');
const app = express()
const config = require('./config.json');
const port = 3001

app.use(express.json());
app.use('/static', express.static('public'))

app.get('/hi', (req, res) => {
  external_resp = axios.get(`${config.externalApiBaseUrl}/hi`)
  // process external_resp.data
  processExternalResp(external_resp.data)
  res.json({msg: 'ok', : external_resp.data})
})

function processExternalResp(data) {
  // do something with data
  console.log(data)
  return data
}


app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})