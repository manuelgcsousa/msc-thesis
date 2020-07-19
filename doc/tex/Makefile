DOCNAME=Thesis

all: report

.PHONY: clean

report:
	pdflatex $(DOCNAME).tex
	bibtex $(DOCNAME).aux
	pdflatex $(DOCNAME).tex
	pdflatex $(DOCNAME).tex
	open $(DOCNAME).pdf

clean:
	rm -rf *.log *.blg *.bbl *.aux *.log *.lof *.loc *.lot *.out *.soc *.toc
