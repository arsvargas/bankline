import { Component, OnInit } from '@angular/core';
import { AccountHolderService } from 'src/app/services/account-holder.service';
import { MovementService } from 'src/app/services/movement.service';

@Component({
  selector: 'app-movement-list',
  templateUrl: './movement-list.component.html',
  styleUrls: ['./movement-list.component.css']
})

export class MovementListComponent implements OnInit {
  movements:any;
  accountHolders:any;
  accountHolder:any={};

  constructor(
    private movementService: MovementService,
    private accountholderService: AccountHolderService
    ) { }

  ngOnInit(): void {
    this.showAccountHolder();
    this.teste();
  }

  teste(): void {
    console.log("INICIOU A PAGINA");
  }
  
  private showAccountHolder(): void {
    this.accountholderService.list()
      .subscribe(
        data => {
          this.accountHolders = data;
          this.accountHolder = data;

          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  listMovements(): void {

    this.movementService.findByIdAccount(this.accountHolder.id)
      .subscribe(
        data => {
          this.movements = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}
