package br.com.iponto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iponto.entities.TipoMarcacao;
import br.com.iponto.repositories.TipoMarcacaoRepository;

@Service
public class TipoMarcacaoService
{

    @Autowired
    private TipoMarcacaoRepository tipoMarcacaoRepositorio;

    public TipoMarcacao getById(int id){

        try
        {
          return tipoMarcacaoRepositorio.findById(id).get();
        }
        catch (Exception e)
        {
            return null;
        }

    }

    public TipoMarcacao save(TipoMarcacao tipoMarcacao) 
    {

        return tipoMarcacaoRepositorio.save(tipoMarcacao);
    }

    public void delete(int id)
    {

        tipoMarcacaoRepositorio.deleteById(id);
    }

}