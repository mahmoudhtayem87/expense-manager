import {Component, Input, OnInit} from '@angular/core';

@Component({
    selector: 'not-signed-in',
    template:
        `
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <h1 class="display-4">You are not authorized to view this content</h1>
                    <p class="lead">Please sign in first to view this content</p>
                </div>
            </div>
        `
})
export class NotsignedInComponent implements OnInit {
    ngOnInit(): void {
    }
}