import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Produto} from '../produto';
import {Router} from '@angular/router';
import {ProdutoService} from '../produto.service';

@Component({
  selector: 'app-produto-lista',
  templateUrl: './produto-lista.component.html',
  styleUrls: ['./produto-lista.component.css']
})
export class ProdutoListaComponent implements OnInit {

  produtos: Observable<Produto[]>;

  constructor(private pessoaService: ProdutoService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.produtos = this.pessoaService.getProdutos();
  }

  deleteProduto(id: number) {
    this.pessoaService.deleteProduto(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error)
    );

    ;
  }

  produtosDetalhes(id: number) {
    this.router.navigate(['details', id]);
  }
}
