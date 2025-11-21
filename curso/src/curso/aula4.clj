(ns curso.aula4)

;Pra usar o namespace no REPL: (use 'curso.aula4)

(def precos [30, 700, 1000])

(println (precos 0))
(println (get precos 0))
(println (get precos 2))

;Linha abaixo dá erro
;(println (precos 20))
(println "valor padrão nil" (get precos 20))
(println "valor padrão 0" (get precos 20 0))

;(println (conj precos 5))
;(println precos)

(+ 5 1)
(inc 5)
(update precos 0 inc)
(update precos 0 dec)
(println precos)

(defn soma-3
  [valor]
  (+ valor 3))

(println (update precos 0 soma-3))

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (map valor-descontado precos))

(println (range 10))
(println (filter even? (range 10)))
(println (filter odd? (range 10)))

(println (filter aplica-desconto? precos))

(println (map valor-descontado (filter aplica-desconto? precos)))


(reduce + precos)

(defn minha-soma
  [acumulado valor-atual]
  (println "Somando" acumulado valor-atual)
  (+ acumulado valor-atual))

;(reduce minha-soma precos)
;(reduce minha-soma (range 10))
;(reduce minha-soma [15])

(reduce minha-soma 0 [15])
(reduce minha-soma 0 [])

;Linha abaixo dá erro
;(reduce minha-soma [])






























