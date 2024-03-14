const axios = require('axios');

const query = `
  query {
    user(id: "2") {
      username
      email
    }
  }
`;

axios.post('http://localhost:8080/graphql', { query })
  .then(response => {
    console.log(response.data);
  })
  .catch(error => {
    console.error(error);
  });