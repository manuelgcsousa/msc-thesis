DOCNAME=Thesis

all: report

.PHONY: clean

report:
	pdflatex $(DOCNAME).tex
	bibtex $(DOCNAME).aux
	pdflatex $(DOCNAME).tex
	pdflatex $(DOCNAME).tex
	mkdir -p __output__ && mv *.blg *.bbl *.aux *.log *.lof *.loc *.lot *.out *.soc *.toc __output__
	open $(DOCNAME).pdf
	
clean:
	rm -rf Thesis.pdf __output__
