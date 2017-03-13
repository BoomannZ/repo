package helper;

import dto.ComicDTO;
import entity.Comic;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by sbushui on 3/13/2017.
 */
public class Transformer {
    public static Comic transformComicDTOToComic(ComicDTO comicDTO) {
        Mapper mapper = new DozerBeanMapper();
        Comic comic = mapper.map(comicDTO,Comic.class);
        return comic;
    }

    public static ComicDTO transformComicToComicDTO(Comic comic) {
        Mapper mapper = new DozerBeanMapper();
        ComicDTO comicDTO = mapper.map(comic,ComicDTO.class);
        return comicDTO;
    }
}
