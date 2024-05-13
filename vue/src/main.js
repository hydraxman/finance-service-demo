import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios'

createApp(App).mount('#app')


axios.post('http://localhost:3000/api/v1/users', {})
    .then(response => {
        console.log(response)
    })