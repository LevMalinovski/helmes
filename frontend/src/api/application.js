import axios from "axios";

const headers = {
    'token': localStorage.getItem('token'),
}

export function create(data) {
    return axios.post(process.env.VUE_APP_BASE_API +'/api/v1/application', data, {headers: headers})
        .then(function (response) {
            return response;
        });
}

export function fetchApplications() {
    return axios.get(process.env.VUE_APP_BASE_API +'/api/v1/application', {headers: headers})
        .then(function (response) {
            return response;
        });
}