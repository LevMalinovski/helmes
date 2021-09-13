import axios from "axios";

export function fetchToken() {
    return axios.get(process.env.VUE_APP_BASE_API +'/api/v1/token')
        .then(function (response) {
            return response;
        });
}