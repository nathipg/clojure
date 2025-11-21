(ns curso.aula3)

; PREDICATE
(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se valor bruto for maior que 100"
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado mais-caro-que-100? 100))
(println (valor-descontado mais-caro-que-100? 200))
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 300))
(println (valor-descontado (fn [v] (> v 100)) 400))
(println (valor-descontado #(> %1 100) 500))
(println (valor-descontado #(> % 100) 600))

; Outra formas de definir funções
(def mais-caro-que-100? (fn [valor-bruto] (> valor-bruto 100)))
(def mais-caro-que-100? #(> % 100))

; HIGHER ORDER FUNCTIONS
; IMUTABILIDADE






































