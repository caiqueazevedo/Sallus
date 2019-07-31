import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Produto} from '../../produto';
import {Router} from '@angular/router';
import {ProdutoService} from '../../produto.service';

@Component({
  selector: 'app-produto-lista',
  templateUrl: './produto-lista.component.html',
  styleUrls: ['./produto-lista.component.css']
})
export class ProdutoListaComponent implements OnInit {

  produtos: Observable<Produto[]>;

  constructor(private produtoService: ProdutoService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.produtos = this.produtoService.getProdutos();
  }

  deleteProduto(id: number) {
    this.produtoService.deleteProduto(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error)
    );

    ;
  }

  editarProduto(id: number) {
    this.router.navigate(['edita', id]);
  }
  produtosDetalhes(id: number) {
    this.router.navigate(['details', id]);
  }
}
