// compoenents/movimentacao-new.component.ts

import { Component, OnInit } from '@angular/core';
import { AccountHolderService } from 'src/app/services/account-holder.service';
import { MovementService } from 'src/app/services/movement.service';

@Component({
  selector: 'app-movement-new',
  templateUrl: './movement-new.component.html',
  styleUrls: ['./movement-new.component.css']
})
export class MovementNewComponent implements OnInit {
  accountHolder:any;
  dateTime:any;
  description:any;
  value:any;
  type:any;

  constructor(
    private movementService: MovementService,
    private accountholderService: AccountHolderService,
    ) { }

  ngOnInit(): void {this.exibirAccountHolder();}
 
  exibirAccountHolder(): void {
    this.accountholderService.list()
      .subscribe(
        data => {
          this.accountHolder = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  save(): void {console.log(this.accountHolder)
    const movement = {
      value:this.value,
      description:this.description,
      type:this.type,
      idAccount:this.accountHolder.id

    };
    console.log(movement);
    this.movementService.create(movement)
      .subscribe(
        response => {
          console.log(response);
        },
        error => {
          console.log(error);
        });
  }

}
