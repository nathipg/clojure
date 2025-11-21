(ns curso.aula6)

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15
  [valor]
  (println "valor" (class valor) valor)
  15)

(defn imprime-e-15
  [[chave valor]]
  (println chave "<e>" valor)
  15)

(println (map imprime-e-15 pedido))

(println "\n\n\n\n\n")

(defn retorna-valor [[_ valor]]
  valor)

(println (map retorna-valor pedido))

(println "\n\n\n\n\n")

(defn preco-por-produto [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

; Thread last - Vai passar como último parâmetro
(defn total-do-pedido
  [pedido]
  ;(reduce + (map preco-por-produto pedido))
  (->> pedido
      (map preco-por-produto)
      (reduce +)))

(println (map preco-por-produto pedido))
(println (total-do-pedido pedido))


;Essa versão é bem mais natural
(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))

(println "\n\n\n\n\n")
(println (total-do-pedido pedido))





(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [[_ item]]
  (<= (get item :preco 0) 0))

(println "\n\n\n\n\nFiltrando gratuitos")
(println (filter gratuito? pedido))



(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println "\n\n\n\n\nFiltrando gratuitos")
(println (filter (fn [[_ item]] (gratuito? item)) pedido))
(println (filter #(gratuito? (second %)) pedido))


;(defn pago?
;  [item]
;  (not (gratuito? item)))

(def pago? (comp not gratuito?))

(println "\n\n\n\n\n")
(println (pago? {:preco 50}))
(println (pago? {:preco 0}))
(println (pago? {}))

(println "\n\n\n\n\n")


;Exercicio - Contar total de certificados
(def clientes [
               { :nome "Guilherme"
                :certificados ["Clojure" "Java" "Machine Learning"] }
               { :nome "Paulo"
                :certificados ["Java" "Ciência da Computação"] }
               { :nome "Daniela"
                :certificados ["Arquitetura" "Gastronomia"] }])
(->> clientes
    (map :certificados)
     (map count)
     (reduce +))
