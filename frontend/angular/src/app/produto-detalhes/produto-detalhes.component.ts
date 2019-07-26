import { Component, OnInit } from '@angular/core';
import {Produto} from '../produto';
import {ActivatedRoute, Router} from '@angular/router';
import {ProdutoService} from '../produto.service';

@Component({
  selector: 'app-produto-detalhes',
  templateUrl: './produto-detalhes.component.html',
  styleUrls: ['./produto-detalhes.component.css']
})
export class ProdutoDetalhesComponent implements OnInit {

  id: number;
  produto: Produto;

  constructor(private route: ActivatedRoute, private router: Router, private produtoService: ProdutoService) { }

  ngOnInit() {
    this.produto = new Produto();
    this.id = this.route.snapshot.params['id'];
    this.produtoService.getProduto(this.id).subscribe(data => {console.log(data);
      this.produto = data;
    }, error => console.log(error));
  }

  list() {
    this.router.navigate(['produtos']);
  }
}
