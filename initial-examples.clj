(defn imprime-mensagem []
  (println "------------------------")
  (println "Bem vindo(a) ao estoque!"))

(imprime-mensagem)

(defn valor-descontado 
  "Retorna o valor com desconto de 10% se valor bruto for maior que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de" desconto)
      (- valor-bruto desconto))
    valor-bruto))

(valor-descontado 100)
(valor-descontado 200)

(class 90.0)
(class 90N)
(class 90M)
