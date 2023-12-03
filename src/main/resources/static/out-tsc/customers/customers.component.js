import { __decorate } from "tslib";
import { Component } from '@angular/core';
let CustomersComponent = class CustomersComponent {
    constructor(customerService) {
        this.customerService = customerService;
        this.customers = []; // Initialize customers array
        this.searchID = 0; // Initialize search term
        this.searchFirstName = ""; // Initialize search term
        this.searchLastName = ""; // Initialize search term
        this.searchEmail = ""; // Initialize search term
        this.err = {};
        this.customer = {};
    }
    ngOnInit() {
        //
        // this.customerService.getALL().subscribe((data:Customer[])=>{
        //     console.warn(data);
        //   this.customers = data
        //
        // }) ;
    }
    save(data) {
        console.warn(data);
        this.customerService.addCustomer(data);
    }
    searchCustomers() {
        this.customer.customerId = this.searchID;
        this.customer.firstName = this.searchFirstName;
        this.customer.lastName = this.searchLastName;
        this.customer.email = this.searchEmail;
        console.warn(this.customer);
        this.customerService.search(this.customer).subscribe((data) => {
            console.log(data);
            // if('customerId' in data){
            // if(Array.isArray(data)){
            //     this.customers = data ;
            //     this.err = {} as ErrorResponse ;
            //
            // }else if('code' in data){
            //
            //    this.customers = [];
            //    this.err=data
            // }
            // this.customers = Array.isArray(data) ? data : [];
            // this.err = Array.isArray(data) ? {} as ErrorResponse : data;
            Array.isArray(data) && (this.customers = data) && (this.err = {});
            !Array.isArray(data) && (Object.keys(data).find(key => key === 'code')) && (this.customers = []) && (this.err = data);
        });
    }
};
CustomersComponent = __decorate([
    Component({
        selector: 'app-customers',
        templateUrl: './customers.component.html',
        styleUrls: ['./customers.component.css']
    })
], CustomersComponent);
export { CustomersComponent };
//# sourceMappingURL=customers.component.js.map