import { Component, OnInit } from '@angular/core';
import {Produto} from '../produto';
import {ProdutoService} from '../produto.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-produto-criacao',
  templateUrl: './produto-criacao.component.html',
  styleUrls: ['./produto-criacao.component.css']
})
export class ProdutoCriacaoComponent implements OnInit {

  produto : Produto = new Produto();
  submitted = false;

  constructor(private produtoService: ProdutoService, private router: Router) { }

  ngOnInit() {
  }

  newProduto(): void {
    this.submitted = false;
    this.produto = new Produto();
  }

  save() {
    this.produtoService.createProduto(this.produto).subscribe(data=> console.log(data), error => console.log(error));
    this.produto = new Produto();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/produtos']);
  }
}
