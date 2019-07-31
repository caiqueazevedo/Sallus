/* tslint:disable */
import { Component, OnInit } from '@angular/core';
import {Produto} from "../../produto";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {ProdutoService} from "../../produto.service";
import {first} from "rxjs/operators";

@Component({
  selector: 'app-produto-editar',
  templateUrl: './produto-editar.component.html',
  styleUrls: ['./produto-editar.component.css']
})
export class ProdutoEditarComponent implements OnInit {

  produto: Produto;
  editForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private produtoService: ProdutoService) { }

  ngOnInit() {
    let produtoId = this.route.snapshot.params['id'];
    if(!produtoId) {
      alert("Ação inválida!")
      this.router.navigate(['produtos']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [],
      nome: ['', Validators.required],
      valor: ['', Validators.required],
      descricao: ['', Validators.required]
    });
    this.produtoService.getProduto(produtoId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    let produtoId = this.route.snapshot.params['id'];
    this.produtoService.updateProduto(produtoId, this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['produtos']);
        },
        error => {
          alert(error);
        });
  }

}
