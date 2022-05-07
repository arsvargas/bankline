import { Component, OnInit } from '@angular/core';
import { AccountHolderService } from 'src/app/services/account-holder.service';

@Component({
  selector: 'app-account-holder',
  templateUrl: './account-holder.component.html',
  styleUrls: ['./account-holder.component.css']
})
export class AccountHoldersComponent implements OnInit {
  accountholders:any;
  cpf:any;
  name:any;

  constructor(
    private accountholdersService: AccountHolderService,
  ) { }

  ngOnInit(): void {
    this.showAccountHolders();
  }

  showAccountHolders(): void {
    this.accountholdersService.list()
      .subscribe(
        data => {
          this.accountholders = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  save(): void {
    const accountholder = {
      cpf:this.cpf,
      name:this.name
    };
    console.log(accountholder);
    this.accountholdersService.create(accountholder)
      .subscribe(
        response => {
          console.log(response);
          this.showAccountHolders();
        },
        error => {
          console.log(error);
        });
  }
}
