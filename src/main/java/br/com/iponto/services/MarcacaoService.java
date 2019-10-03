package br.com.iponto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iponto.entities.Marcacao;
import br.com.iponto.repository.MarcacaoRepositorio;

@Service
public class MarcacaoService{

    @Autowired
    private MarcacaoRepositorio marcacaoRepositorio;

    public Marcacao getbyId(int id)
    {
        try
        {
            return marcacaoRepositorio.findById(id).get();
        }
        catch (Exception e)
        {
            return null;
        }

    }

    public Marcacao save(Marcacao marcacao)
    {
        return marcacaoRepositorio.save(marcacao);
    }

    public void delete(int id)
    {
        marcacaoRepositorio.deleteById(id);
    }


}