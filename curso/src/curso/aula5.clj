(ns curso.aula5)

(def estoque {
  "mochila" 10
  "camiseta" 5})
(println estoque)

(println "Temos" (count estoque) "elementos")
(println "Chaves:" (keys estoque))
(println "Valores:" (vals estoque))

;keyword
:mochila

(def estoque {:mochila 10
              :camiseta 5})

(println (assoc estoque :cadeira 3))

(println (update estoque :mochila inc))

(defn tira-um
  [valor]
  (println "tirando um de" valor)
  (- valor 1))

(println (update estoque :mochila tira-um))
(println (update estoque :mochila #(- % 3)))

(println (dissoc estoque :mochila))


(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(println "\n\n\n\n")
(println pedido)

(def pedido (assoc pedido :chaveiro {:quantidade 1 :preco 10}))
(println "\n\n\n\n")
(println pedido)

;Raramente usado, pode dar erro
(println (pedido :mochila))

;Pouco usado
(println (get pedido :mochila))
(println (get pedido :cadeira))
(println (get pedido :cadeira 0))
(println (get pedido :cadeira {}))

;Forma mais comum
(println (:mochila pedido))
(println (:cadeira pedido))
(println (:cadeira pedido {}))

(println (:quantidade (:mochila pedido)))

(println (update-in pedido [:mochila :quantidade] inc))

;Threading - Encadeando ("Passando um fio")
;Essa é a forma mais usada
;Thread first - Vai passar como primeiro parâmetro
(println (-> pedido
             :mochila
             :quantidade))

;É possível fazer isso, mas não recomendado
(-> pedido
    :mochila
    :quantidade
    println)


;Exercicio
(def
  clientes {
    :15 {
      :nome "Guilherme"
      :certificados ["Clojure" "Java" "Machine Learning"] } })

(println (-> clientes
             :15
             :certificados
             count))






































