import {Component, Input, OnInit} from '@angular/core';

@Component({
    selector: 'no-data',
    template:
        `
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <h1 class="display-4">No Data Available</h1>
                    <p class="lead">You did not create any expense(s) yet, please use the "Create" button to create your first expense</p>
                </div>
            </div>
        `
})
export class noDataComponent implements OnInit {
    ngOnInit(): void {
    }

}