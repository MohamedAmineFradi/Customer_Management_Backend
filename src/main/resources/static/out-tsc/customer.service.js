import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
import { switchMap, tap } from "rxjs";
let CustomerService = class CustomerService {
    constructor(_http) {
        this._http = _http;
        this.apis = '../assets/apis.json';
        this.path = '';
    }
    addCustomer(data) {
        this._http.get(this.apis).subscribe(response => {
            this.url2 = response;
            console.log(this.url2[0]["url"]);
            this._http.post(this.url2[0]["url"], data).subscribe(result => {
                console.warn("result: ", result);
            });
        });
    }
    getALL() {
        return this._http.get(this.apis).pipe(tap(response => {
            this.url3 = response;
            console.log(this.url3[2]["url"]);
            //let p = this.url3[2]["url"];
            // this._http.get<any>(p).subscribe((data: Customer[]) => {
            //   console.warn(data);
            // });
        }), switchMap(response => {
            let p = this.url3[2]["url"];
            return this._http.get(p);
        }));
    }
    search(searchCriteria) {
        return this._http.get(this.apis).pipe(switchMap((response) => {
            this.url2 = response;
            console.log(this.url2[1]["url"]);
            return this._http.post(this.url2[1]["url"], searchCriteria);
        }));
    }
};
CustomerService = __decorate([
    Injectable({
        providedIn: 'root'
    })
], CustomerService);
export { CustomerService };
//# sourceMappingURL=customer.service.js.map